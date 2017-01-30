package zad4;

import javax.swing.*;
import java.awt.*;

class IconA implements Icon
{
	private Color color;
	private int w = 40;
	private boolean frame;
	IconA()
	{
	}
	IconA(Color c)
	{
		color = c;
	}

	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Color old = g.getColor();
		g.setColor(color);
		w = ((JComponent) c).getHeight() / 2;
		int p = w / 4, d = w / 2;
		g.fillOval(x + p, y + p, d, d);
		if (frame)
			g.drawRect(x, y, w - 1, w - 1);
		g.setColor(old);
	}

	public int getIconWidth()
	{
		return w;
	}

	public int getIconHeight()
	{
		return w;
	}
}
