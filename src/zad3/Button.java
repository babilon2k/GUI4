package zad3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Button extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 6928160054284829560L;
	JButton bColorChanger = new JButton("Zmień kolor!");
	Color[] c = new Color[8];

	public Button()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createButton();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if (source == bColorChanger)
			bColorChanger.setBackground(colorMaker());

	}

	public Color colorMaker()
	{
		for (int i = 0; i < c.length; i++)
		{
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color randomColor = new Color(r, g, b);
			c[i] = randomColor;
		}
		return c[0];
	}

	protected void createButton()
	{
		setTitle("Kolorowy Guzik");
		setLayout(new GridLayout());
		setPreferredSize(new Dimension(300, 200));

		bColorChanger.addActionListener(this);
		bColorChanger.setSize(200, 200);
		add(bColorChanger);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);

		setVisible(true);
	}

}
