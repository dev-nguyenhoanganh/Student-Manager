/**
 * @Project_Name 32_AnhNH_Ex1_Quan Ly
 */
package com.luvina.test.gui.panel;

import javax.swing.JPanel;

import com.luvina.test.gui.icommon.ICommon;

/**
 * @author Hoang Anh
 * @since 26 thg 1, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class BasePanel extends JPanel implements ICommon{
	public BasePanel() {
		init();
		addComponent();
		addEvent();
	}
}
