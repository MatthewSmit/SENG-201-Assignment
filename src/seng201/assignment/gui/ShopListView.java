package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Component;

class ShopListViewRenderer extends JPanel implements ListCellRenderer<ShopListView> {
	private JLabel lhsLabel;
	private JLabel rhsLabel;
	
	public ShopListViewRenderer() {
		setLayout(new BorderLayout(0, 0));

		lhsLabel = new JLabel();
		rhsLabel = new JLabel();
		
		add(lhsLabel);
		add(rhsLabel, BorderLayout.EAST);
	}

	public Component getListCellRendererComponent(
			JList<? extends ShopListView> list,           // the list
			ShopListView value,            // value to display
			int index,               // cell index
			boolean isSelected,      // is the cell selected
			boolean cellHasFocus)    // does the cell have focus
	{
		lhsLabel.setText(value.getLhs());
		rhsLabel.setText(value.getRhs());
		
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
		
		return this;
	}
}

public class ShopListView {
	private String lhs;
	private String rhs;
	
	public ShopListView(String lhs, String rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public String getLhs() {
		return lhs;
	}
	
	public String getRhs() {
		return rhs;
	}
}
