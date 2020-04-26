// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer

import java.awt.{BorderLayout, Color}
import javax.swing.{BorderFactory, JPanel}

case class ColorMixerPanel() extends JPanel {

  private val colorA = new Color(0, 140, 255)
  private val colorB = new Color(255, 40, 60)

  private val mixedColorsPanel = MixedColorsScrollPane(colorA, colorB)
  mixedColorsPanel.setBorder(BorderFactory.createEtchedBorder)

  private val controlsPanel = ColorControlsPanel(colorA, colorB, mixedColorsPanel)

  setLayout(new BorderLayout)
  add(controlsPanel, BorderLayout.NORTH)
  add(mixedColorsPanel, BorderLayout.CENTER)
}
