// Copyright by Barry G. Becker, 2005-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer.ui

import java.awt.Color

trait ColorChangeListener {

  def colorChanged(colorA: Color, opacityA: Float, colorB: Color, opacityB: Float): Unit

  def opacityChanged(opacityA: Float, opacityB: Float): Unit

}
