/*
 * Copyright 2006-2011 The MZmine 2 Development Team
 * 
 * This file is part of MZmine 2.
 * 
 * MZmine 2 is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine 2 is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine 2; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package net.sf.mzmine.modules.rawdatamethods.peakpicking.massdetection.wavelet;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import net.sf.mzmine.main.MZmineCore;
import net.sf.mzmine.modules.rawdatamethods.peakpicking.massdetection.MassDetectorSetupDialog;
import net.sf.mzmine.parameters.SimpleParameterSet;
import net.sf.mzmine.parameters.UserParameter;
import net.sf.mzmine.parameters.parametertypes.NumberParameter;
import net.sf.mzmine.util.GUIUtils;
import net.sf.mzmine.util.dialogs.ExitCode;

public class WaveletMassDetectorParameters extends SimpleParameterSet {

	public static final NumberParameter noiseLevel = new NumberParameter(
			"Noise level",
			"Intensities less than this value are interpreted as noise",
			MZmineCore.getIntensityFormat());

	public static final NumberParameter scaleLevel = new NumberParameter(
			"Scale level",
			"Number of wavelet'scale (coeficients) to use in m/z peak detection",
			DecimalFormat.getIntegerInstance());

	public static final NumberParameter waveletWindow = new NumberParameter(
			"Wavelet window size (%)",
			"Size in % of wavelet window to apply in m/z peak detection",
			NumberFormat.getPercentInstance());

	public WaveletMassDetectorParameters() {
		super(new UserParameter[] { noiseLevel, scaleLevel, waveletWindow });
	}

	public ExitCode showSetupDialog() {
		String helpID = GUIUtils.generateHelpID(this);
		MassDetectorSetupDialog dialog = new MassDetectorSetupDialog(
				WaveletMassDetector.class, this, helpID);
		dialog.setVisible(true);
		return dialog.getExitCode();
	}
}