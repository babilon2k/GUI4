package zad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class Labels extends JFrame
{
	private static final long serialVersionUID = 4411859909302563657L;

	public Labels()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createLabelsExamp();
			}
		});

	}

	private void createLabelsExamp()
	{
		BorderLayout borderLayout = new BorderLayout();

		JLabel nLabel = new JLabel("North Label!", SwingConstants.CENTER);
		nLabel.setBackground(Color.BLACK);
		nLabel.setOpaque(true);
		nLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		nLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		nLabel.setToolTipText("To ja etykieta północna!");
		nLabel.setForeground(Color.red);

		JLabel sLabel = new JLabel("South Label!", SwingConstants.CENTER);
		sLabel.setBackground(Color.GREEN);
		sLabel.setOpaque(true);
		sLabel.setFont(new Font("Serif", Font.BOLD, 18));
		sLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		sLabel.setToolTipText("To ja etykieta połódniowa!");
		sLabel.setForeground(Color.black);

		JLabel cLabel = new JLabel("Center Label!");
		cLabel.setBackground(Color.pink);
		cLabel.setOpaque(true);
		cLabel.setFont(new Font("Aerial", Font.ITALIC, 28));
		cLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		cLabel.setToolTipText("To ja etykieta centralna!");
		cLabel.setForeground(Color.blue);

		JLabel eLabel = new JLabel("East Label!");
		eLabel.setBackground(Color.ORANGE);
		eLabel.setOpaque(true);
		eLabel.setFont(new Font("Dialog", Font.ITALIC, 16));
		eLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		eLabel.setToolTipText("To ja etykieta wschodnia!");
		eLabel.setForeground(Color.white);

		JLabel wLabel = new JLabel("West Label!");
		wLabel.setBackground(Color.ORANGE);
		wLabel.setOpaque(true);
		wLabel.setFont(new Font("MONOSPACED", Font.ROMAN_BASELINE, 16));
		wLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		wLabel.setToolTipText("To ja etykieta zachodnia!");
		wLabel.setForeground(Color.white);

		setLayout(borderLayout);
		setTitle("Etykiety w BorderLayout");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(nLabel);
		add(sLabel);
		add(cLabel);
		add(eLabel);
		add(wLabel);
		borderLayout.addLayoutComponent(nLabel, BorderLayout.NORTH);
		borderLayout.addLayoutComponent(sLabel, BorderLayout.SOUTH);
		borderLayout.addLayoutComponent(cLabel, BorderLayout.CENTER);
		borderLayout.addLayoutComponent(eLabel, BorderLayout.EAST);
		borderLayout.addLayoutComponent(wLabel, BorderLayout.WEST);
		pack();
		setVisible(true);
	}
}