// Copyright by Barry G. Becker, 2005-2018. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import com.barrybecker4.ui.util.GUIUtil
import javax.swing._
import java.awt._

import MixPanel._
import com.barrybecker4.colormixer.model.PorterDuffRule
import javax.swing.border.EmptyBorder


object MixPanel {
  private val HEIGHT = 60
  private val TITLE_FONT = new Font(GUIUtil.DEFAULT_FONT_FAMILY, Font.BOLD, 16)
}

/**
  * Shows the color mixer for a given rule along with title and description
  */
class MixPanel(var colorA: Color, var colorB: Color, val rule: PorterDuffRule) extends JPanel {

  private val titlePanel = new JLabel("<html>" + rule.name + "</html>")
  titlePanel.setBorder(new EmptyBorder(0, 5, 0, 0))
  titlePanel.setFont(TITLE_FONT)
  titlePanel.setVerticalAlignment(SwingConstants.TOP)

  val minDim = new Dimension(140, HEIGHT)
  val dim = new Dimension(160, HEIGHT)
  titlePanel.setMinimumSize(minDim)
  titlePanel.setPreferredSize(dim)
  titlePanel.setMaximumSize(dim)

  private val swatchPanel: SwatchPanel = new SwatchPanel(colorA, colorB, rule.compositeRule)
  swatchPanel.setMinimumSize(minDim)
  swatchPanel.setPreferredSize(dim)

  private val descPanel = new JLabel("<html>" + rule.description + "</html>")
  val descDim = new Dimension(600, HEIGHT)
  descPanel.setMinimumSize(minDim)
  descPanel.setPreferredSize(descDim)
  descPanel.setMaximumSize(descDim)
  descPanel.setVerticalAlignment(SwingConstants.TOP)

  setLayout(new BoxLayout(this, BoxLayout.X_AXIS))
  setToolTipText(rule.description)

  add(titlePanel)
  add(swatchPanel)
  add(descPanel)

  def setColors(colorA: Color, opacityA: Float, colorB: Color, opacityB: Float): Unit =
    swatchPanel.setColors(colorA, opacityA, colorB, opacityB)

  def setOpacityA(op: Float): Unit = swatchPanel.setOpacityA(op)
  def setOpacityB(op: Float): Unit = swatchPanel.setOpacityB(op)
}