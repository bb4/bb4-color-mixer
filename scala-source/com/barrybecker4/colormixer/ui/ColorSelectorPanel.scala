// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import java.awt.Color
import java.awt.event.ActionListener
import java.text.DecimalFormat
import java.util

import com.barrybecker4.ui.components.ColorInputPanel
import javax.swing.event.{ChangeEvent, ChangeListener}
import javax.swing._
import ColorSelectorPanel._
import SwatchPanel.INITIAL_OPACITY_A


object ColorSelectorPanel {
  private val SLIDER_TICKS = 100
  private val OPACITY_FORMAT = new DecimalFormat("#.00")
  private def opFormat(op: Float): String = {
    if (op > 0.994) "1.0" else OPACITY_FORMAT.format(op)
  }
}
/**
  * Allows you to select a color and its opacity
  */
class ColorSelectorPanel(label: String, tooltip: String,
                         initialColor: Color, initialOpacity: Float,
                         aListener: ActionListener, changeListener: ChangeListener ) extends JPanel {

  private val colorButton: JButton = createColorButton(initialColor)
  private val opacitySlider: JSlider = createOpacitySlider
  private val opacitySliderLabel: JLabel = new JLabel(s"Opacity ($INITIAL_OPACITY_A)")

  val colorPanel = new ColorInputPanel(label, tooltip, colorButton, aListener)

  setLayout(new BoxLayout(this, BoxLayout.X_AXIS))
  add(colorPanel)
  add(Box.createHorizontalStrut(15))
  add(opacitySliderLabel)
  add(opacitySlider)
  setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10))

  def getColor: Color = colorButton.getBackground
  def getOpacity: Float = opacitySlider.getValue.toFloat / SLIDER_TICKS

  private def createOpacitySlider = {
    val initialSliderValue = (initialOpacity * SLIDER_TICKS).toInt
    val opacitySlider = new JSlider(SwingConstants.HORIZONTAL, 0, SLIDER_TICKS, initialSliderValue)
    opacitySlider.setMajorTickSpacing(SLIDER_TICKS)
    opacitySlider.setMinorTickSpacing(SLIDER_TICKS)

    opacitySlider.setToolTipText("Control the opacity of the color")
    val dict = new util.Hashtable[Integer, JLabel]
    dict.put(0, new JLabel("0"))
    dict.put(SLIDER_TICKS / 2, new JLabel("0.5"))
    dict.put(SLIDER_TICKS, new JLabel("1.0"))
    opacitySlider.setLabelTable(dict)
    opacitySlider.setPaintLabels(true)

    opacitySlider.addChangeListener(changeListener)
    opacitySlider.addChangeListener((e: ChangeEvent) => {
      opacitySliderLabel.setText(s"Opacity (${opFormat(this.getOpacity)})")
    })
    opacitySlider
  }

  private def createColorButton(initialColor: Color) = {
    val colorButton = new JButton("   ")
    colorButton.setBackground(initialColor)
    colorButton
  }
}