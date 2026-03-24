package com.barrybecker4.colormixer.model

import java.awt.Color

object ColorOps:

  /** Build an ARGB color with alpha derived from opacity (clamped to [0, 1] before scaling). */
  def withOpacity(color: Color, opacity: Float): Color =
    val t = math.min(1f, math.max(0f, opacity))
    val alpha = math.round(255f * t).toInt
    new Color(color.getRed, color.getGreen, color.getBlue, alpha)
