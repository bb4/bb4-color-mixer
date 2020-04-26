// Copyright by Barry G. Becker, 2019-2020. Licensed under MIT License: http://www.opensource.org/licenses/MIT
package com.barrybecker4.colormixer

import java.awt.Color


trait ColorChangeListener {

  def colorChanged(colorA: Color, opacityA: Float, colorB: Color, opacityB: Float)

  def opacityChanged(opacityA: Float, opacityB: Float)

}
