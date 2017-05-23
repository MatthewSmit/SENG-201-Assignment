package seng201.assignment.gui;

import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.BorderLayout;
import java.awt.Component;

@SuppressWarnings("serial")
class ShopListViewRenderer<T> extends JPanel implements ListCellRenderer<ShopListView<T>> {
	private JLabel lhsLabel;
	private JLabel rhsLabel;
	
	public ShopListViewRenderer() {
		setLayout(new BorderLayout(0, 0));

		lhsLabel = new JLabel();
		rhsLabel = new JLabel();
		
		add(lhsLabel);
		add(rhsLabel, BorderLayout.EAST);
	}

	public Component getListCellRendererComponent(JList<? extends ShopListView<T>> list, ShopListView<T> value,
	                                              int index, boolean isSelected, boolean cellHasFocus) {
		lhsLabel.setText(value.getLhs().toString());
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

public class ShopListView<T> {
	private T lhs;
	private String rhs;
	
	public ShopListView(T lhs, String rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public T getLhs() {
		return lhs;
	}
	
	public String getRhs() {
		return rhs;
	}
}
