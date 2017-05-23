package seng201.assignment.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
class JTextFieldLimit extends PlainDocument {
    private final int limit;

    JTextFieldLimit(final int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(final int offset, final String str, final AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
