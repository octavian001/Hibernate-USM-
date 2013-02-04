package com.service.auto.Interface;

import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import TModel.TableModelAuto;

import com.service.auto.Factory;
import com.service.auto.AUTO;

public class IFrameAuto extends JInternalFrame {

	static JInternalFrame autoFrame = null;

	public static synchronized JInternalFrame getAutoFrame() {

		ArrayList<AUTO> auto = (ArrayList<AUTO>) Factory.getInstance()
				.getAutoDAO().getAllAuto();

		if (autoFrame == null) {
			autoFrame = new JInternalFrame("AUTO", false, true, false, true);
			autoFrame.setSize(900, 600);
			autoFrame.setLocation(30, 20);
			autoFrame.setVisible(true);

			TableModel model = new TableModelAuto(auto);
			JTable t = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(t);
			autoFrame.getContentPane().add(scrollPane);

		}
		return autoFrame;
	}
}
