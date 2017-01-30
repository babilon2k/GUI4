package zad2;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class Layman2 extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Layman2()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createLayman2Examp();
			}
		});
	}
	private void createLayman2Examp()
	{
		JFrame f = new JFrame("Layman2");
		JPanel p = new JPanel();
		JTextArea ta = new JTextArea("To jest JTextArea", 25, 80);
		JScrollPane sp = new JScrollPane(ta);
		sp.setPreferredSize(new Dimension(200, 200));
		JTextField tf = new JTextField("To jest JTextField", 20);

		p.setLayout(new MigLayout());

		p.add(new JButton("A1"), "left align");
		p.add(new JButton("A2"), "left align");
		p.add(new JButton("A3"), "left align, gap right 70");
		p.add(new JButton("B1"), "right align");
		p.add(new JButton("B2"), "right align");
		p.add(new JButton("B3"), "right align, wrap 20");
		p.add(sp, "wrap, span 7 1, height 200, width 550");

		for (int i = 1; i < 10; i++)
		{
			if (i == 3 || i == 6)
			{
				p.add(new JButton("" + i));
				p.add(new JTextField("To jest JTextField", 20),
						"align right, wrap");
			} else
				p.add(new JButton("" + i));
		}
		p.add(tf, "align right");

		f.add(p);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
