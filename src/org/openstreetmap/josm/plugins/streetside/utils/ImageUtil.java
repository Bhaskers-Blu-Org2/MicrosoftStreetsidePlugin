// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the GPLv3 license.
package org.openstreetmap.josm.plugins.streetside.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;
import org.openstreetmap.josm.tools.I18n;

public final class ImageUtil {

  final static Logger logger = Logger.getLogger(ImageUtil.class);

  private ImageUtil() {
    // Private constructor to avoid instantiation
  }

  /**
   * Scales an {@link ImageIcon} to the desired size
   * @param icon the icon, which should be resized
   * @param size the desired length of the longest edge of the icon
   * @return the resized {@link ImageIcon}. It is the same object that you put in,
   *         only the contained {@link Image} is exchanged.
   */
  public static ImageIcon scaleImageIcon(final ImageIcon icon, int size) {
    if(StreetsideProperties.DEBUGING_ENABLED.get()) {
      logger.debug(I18n.tr("Scale icon {0} → {1}", icon.getIconWidth(), size));
    }
    return new ImageIcon(icon.getImage().getScaledInstance(
      icon.getIconWidth() >= icon.getIconHeight() ? size : Math.max(1, Math.round(icon.getIconWidth() / (float) icon.getIconHeight() * size)),
      icon.getIconHeight() >= icon.getIconWidth() ? size : Math.max(1, Math.round(icon.getIconHeight() / (float) icon.getIconWidth() * size)),
      Image.SCALE_SMOOTH
    ));
  }
}
