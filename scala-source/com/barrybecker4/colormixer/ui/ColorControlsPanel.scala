// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import java.awt.Color
import java.awt.event.{ActionEvent, ActionListener}
import com.barrybecker4.colormixer.ui.SwatchPanel.{INITIAL_OPACITY_A, INITIAL_OPACITY_B}
import javax.swing.event.{ChangeEvent, ChangeListener}
import javax.swing.{BorderFactory, Box, BoxLayout, JPanel}

/**
 * Top controls allow user to change the two colors and their opacity
 */
case class ColorControlsPanel(
  initialColorA: Color, initialColorB: Color, colorChangeListener: ColorChangeListener)
  extends JPanel with ActionListener with ChangeListener {

  assert(colorChangeListener != null)
  private var colorSelectorA: ColorSelectorPanel = _
  private var colorSelectorB: ColorSelectorPanel = _
  private val colorA = initialColorA
  private val colorB = initialColorB

  colorSelectorA = new ColorSelectorPanel("Select first color :       ",
    "Select the first color to mix (under/source)",
    colorA, INITIAL_OPACITY_A, this, this)
  colorSelectorB = new ColorSelectorPanel("Select second color : ",
    "Select the second color to mix (over/dest)",
    colorB, INITIAL_OPACITY_B, this, this)

  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
  add(colorSelectorA)
  add(Box.createVerticalStrut(5))
  add(colorSelectorB)
  setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))


  /** Called when a button is pressed */
  override def actionPerformed(e: ActionEvent): Unit = {
    val opA = colorSelectorA.getOpacity
    val opB = colorSelectorB.getOpacity
    colorChangeListener.colorChanged(colorSelectorA.getColor, opA, colorSelectorB.getColor, opB)
  }

  /** Called when opacity slider is moved */
  override def stateChanged(ce: ChangeEvent): Unit = {
    val opA = colorSelectorA.getOpacity
    val opB = colorSelectorB.getOpacity
    colorChangeListener.opacityChanged(opA, opB)
  }
}
