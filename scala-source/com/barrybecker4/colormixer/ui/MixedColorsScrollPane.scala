// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import javax.swing._
import java.awt._
import ScrollPaneConstants._
import com.barrybecker4.colormixer.model.porterDuffRules


/**
  * Shows all the different ways to mix the colors using the Port/Duff rules
  */
case class MixedColorsScrollPane(colorA: Color, colorB: Color)
  extends JPanel with ColorChangeListener {

  private[colormixer] var mainPanel = new JPanel()
  mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS))

  private[colormixer] var scrollPane =
    new JScrollPane(mainPanel, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED)

  private val mixPanels = porterDuffRules.map(new MixPanel(colorA, colorB, _))

  mixPanels.foreach(p => {
    p.setPreferredSize(new Dimension(200, 60))
    mainPanel.add(p)
  })

  this.setLayout(new BorderLayout)
  this.add(scrollPane, BorderLayout.CENTER)

  def setColorsToMix(colorA: Color, opacityA: Float, colorB: Color, opacityB: Float): Unit =
    for (p <- mixPanels) p.setColors(colorA, opacityA, colorB, opacityB)

  def setOpacityA(opacity: Float): Unit =
    for (p <- mixPanels) p.setOpacityA(opacity)

  def setOpacityB(opacity: Float): Unit =
    for (p <- mixPanels) p.setOpacityB(opacity)

  override def colorChanged(colorA: Color, opA: Float, colorB: Color, opB: Float): Unit = {
    setColorsToMix(colorA, opA, colorB, opB)
    repaint()
  }

  override def opacityChanged(opA: Float, opB: Float): Unit = {
    setOpacityA(opA)
    setOpacityB(opB)
    repaint()
  }
}
