package connection;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public  class MyTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // 偶数行背景设置为白色，奇数行背景设置为灰色
        if (row % 2 == 0) {
            setBackground(Color.WHITE);
        } else {
            setBackground(Color.LIGHT_GRAY);
        }

        // 所有列居中对齐
        setHorizontalAlignment(SwingConstants.CENTER);

        // 设置提示文本，当鼠标移动到当前(row, column)所在单元格时显示的提示文本
        setToolTipText("提示的内容: " + row + ", " + column);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}