// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import com.barrybecker4.colormixer.model.ColorOps
import java.awt.*
import java.awt.image.BufferedImage
import javax.swing._


object SwatchPanel:
  val INITIAL_OPACITY_A = 1.0f
  val INITIAL_OPACITY_B = 0.5f

/**
  * Shows the mixed color swatches inside the MixPanel
  * @author Barry Becker
  */
class SwatchPanel(var colorA: Color, var colorB: Color, var rule: Int) extends JPanel:

  import SwatchPanel.*

  private var opacityA = 0f
  private var opacityB = 0f
  setColors(colorA, INITIAL_OPACITY_A, colorB, INITIAL_OPACITY_B)

  def setColors(colorA: Color, opacityA: Float, colorB: Color, opacityB: Float): Unit =
    this.colorA = colorA
    this.colorB = colorB
    this.opacityA = opacityA
    this.opacityB = opacityB

  def setOpacityA(op: Float): Unit =
    opacityA = op

  def setOpacityB(op: Float): Unit =
    opacityB = op

  override protected def paintComponent(g: Graphics): Unit =
    super.paintComponent(g)
    val g2 = g.asInstanceOf[Graphics2D]
    drawBackground(g2)
    drawColorSwatchesInImage(g2, getWidth - 50, getHeight / 2 - 10)

  private def drawBackground(g2: Graphics2D): Unit =
    g2.setColor(Color.WHITE)
    g2.fillRect(1, 1, getWidth - 2, getHeight - 2)

  private def drawColorSwatchesInImage(g2: Graphics2D, width: Int, height: Int): Unit =
    val w = getWidth - 2
    val h = getHeight - 2
    val buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
    val gbi = buffImg.createGraphics
    try
      g2.setColor(Color.WHITE)
      g2.fillRect(1, 1, w, h)

      gbi.setColor(ColorOps.withOpacity(colorA, opacityA))
      gbi.fillRect(5, 10, width, height)

      gbi.setComposite(AlphaComposite.getInstance(rule, opacityB))

      gbi.setColor(ColorOps.withOpacity(colorB, opacityB))
      gbi.fillRect(35, 20, width, height)

      g2.drawImage(buffImg, null, 0, 0)
    finally gbi.dispose()
