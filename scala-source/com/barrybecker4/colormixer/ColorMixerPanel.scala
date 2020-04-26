package com.barrybecker4.colormixer

import java.awt.{BorderLayout, Color}
import java.awt.event.{ActionEvent, ActionListener}

import com.barrybecker4.colormixer.SwatchPanel.{INITIAL_OPACITY_A, INITIAL_OPACITY_B}
import javax.swing.event.{ChangeEvent, ChangeListener}
import javax.swing.{BorderFactory, Box, BoxLayout, JPanel}

case class ColorMixerPanel() extends JPanel with ActionListener with ChangeListener {

  private var colorSelectorA: ColorSelectorPanel = _
  private var colorSelectorB: ColorSelectorPanel = _
  private val colorA = new Color(0, 140, 255)
  private val colorB = new Color(255, 40, 60)
  private var mixedColorsPanel: MixedColorsScrollPane = _

  initialize()

  def initialize(): Unit = {
    mixedColorsPanel = new MixedColorsScrollPane(colorA, colorB)
    mixedColorsPanel.setBorder(BorderFactory.createEtchedBorder)
    colorSelectorA = new ColorSelectorPanel("Select first color :       ",
      "Select the first color to mix (under/source)",
      colorA, INITIAL_OPACITY_A, this, this)
    colorSelectorB = new ColorSelectorPanel("Select second color : ",
      "Select the second color to mix (over/dest)",
      colorB,INITIAL_OPACITY_B, this, this)


    setLayout(new BorderLayout)

    val controlsPanel = createControlsPanel()

    add(controlsPanel, BorderLayout.NORTH)
    add(mixedColorsPanel, BorderLayout.CENTER)
  }

  private def createControlsPanel(): JPanel = {
    val controlsPanel = new JPanel
    controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS))
    controlsPanel.add(colorSelectorA)
    controlsPanel.add(Box.createVerticalStrut(5))
    controlsPanel.add(colorSelectorB)
    controlsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
    controlsPanel
  }

  /** Called when a button is pressed */
  override def actionPerformed(e: ActionEvent): Unit = {
    val opA = colorSelectorA.getOpacity
    val opB = colorSelectorB.getOpacity
    mixedColorsPanel.setColorsToMix(colorSelectorA.getColor, opA, colorSelectorB.getColor, opB)
  }

  override def stateChanged(ce: ChangeEvent): Unit = {
    val opA = colorSelectorA.getOpacity
    val opB = colorSelectorB.getOpacity
    mixedColorsPanel.setOpacityA(opA)
    mixedColorsPanel.setOpacityB(opB)
  }
}
