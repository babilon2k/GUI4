package zad4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class EditorGui extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame();
	JMenuBar menuBar = new JMenuBar();
	JFileChooser fileChooser = new JFileChooser();
	JTextArea ta = new JTextArea(50, 100);
	String[] colorsString = {"Blue", "Yellow", "Orange", "Red", "White",
			"Black", "Green"};
	Color[] colors = {Color.blue, Color.yellow, Color.orange, Color.red,
			Color.white, Color.black, Color.green};

	Icon[] icons = {new IconA(Color.blue), new IconA(Color.yellow),
			new IconA(Color.orange), new IconA(Color.red),
			new IconA(Color.white), new IconA(Color.black),
			new IconA(Color.green)};
	Font[] fonts = {new Font("Lucida Console", 0, 8),
			new Font("Lucida Console", 0, 10),
			new Font("Lucida Console", 0, 12),
			new Font("Lucida Console", 0, 14),
			new Font("Lucida Console", 0, 16),
			new Font("Lucida Console", 0, 18),
			new Font("Lucida Console", 0, 20),
			new Font("Lucida Console", 0, 22),
			new Font("Lucida Console", 0, 24)};

	String[] fontsString = {"8 pts", "10 pts", "12 pts", "14 pts", "16 pts",
			"18 pts", "20 pts", "22 pts", "24 pts"};

	public EditorGui()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				createEditorGui();
			}
		});
	}

	JMenuItem mi(String t, char mnemo, String accel, ActionListener al)
	{
		JMenuItem mi = new JMenuItem(t);
		mi.setBorder(BorderFactory.createRaisedBevelBorder());
		mi.setMnemonic(mnemo);
		mi.setAccelerator(KeyStroke.getKeyStroke(accel));
		mi.addActionListener(this);
		return mi;

	}
	JMenuItem mi(String t, Icon icons, ActionListener al)
	{
		JMenuItem mi = new JMenuItem(t, icons);
		mi.setBorder(BorderFactory.createRaisedBevelBorder());
		mi.addActionListener(this);
		return mi;

	}
	JMenuItem mi(String t, ActionListener al)
	{
		JMenuItem mi = new JMenuItem(t);
		mi.setBorder(BorderFactory.createRaisedBevelBorder());
		mi.addActionListener(this);
		return mi;

	}

	public void createEditorGui()
	{

		JSeparator sep = new JSeparator();
		sep.setBackground(Color.red);

		JScrollPane sp = new JScrollPane(ta);

		JMenu menuFile = new JMenu("File");
		menuFile.add(mi("Open", 'o', "control O", this));
		menuFile.add(mi("Save", 's', "control S", this));
		menuFile.add(mi("Save as...", 'a', "control A", this));
		menuFile.add(sep);
		menuFile.add(mi("Exit", 'x', "control X", this));

		JMenu menuEdit = new JMenu("Edit");
		JMenu adresy = new JMenu("Adresy");
		menuEdit.add(adresy);
		adresy.setBorder(BorderFactory.createRaisedBevelBorder());
		adresy.add(mi("Praca", 'p', "control shift P", this));
		adresy.add(mi("Szkoła", 's', "control shift S", this));
		adresy.add(mi("Dom", 'd', "control shift D", this));

		JMenu menuOptions = new JMenu("Options");
		JMenu foreground = new JMenu("Foreground");
		JMenu background = new JMenu("Background");
		JMenu fontsize = new JMenu("Font size");
		menuOptions.add(foreground);
		foreground.setBorder(BorderFactory.createRaisedBevelBorder());
		background.setBorder(BorderFactory.createRaisedBevelBorder());
		fontsize.setBorder(BorderFactory.createRaisedBevelBorder());
		for (int i = 0; i < 7; i++)
		{
			JMenuItem mi = new JMenuItem();
			foreground.add(mi(colorsString[i], icons[i], this));
			mi.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		menuOptions.add(background);
		for (int i = 0; i < 7; i++)
		{
			background.add(mi(colorsString[i], icons[i], this));
		}
		menuOptions.add(fontsize);
		for (int i = 0; i < fontsString.length; i++)
		{
			fontsize.add(mi(fontsString[i], this));

		}

		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuOptions);
		frame.setLayout(new GridLayout());
		frame.add(sp);
		frame.setJMenuBar(menuBar);
		frame.setTitle("Prosty edytor - bez tytułu");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// File menu
		if ("Open".equals(e.getActionCommand()))
		{
			open();
		}

		if ("Save".equals(e.getActionCommand()))
		{
			save();
		}

		if ("Save as...".equals(e.getActionCommand()))
		{
			saveas();
		}

		if ("Exit".equals(e.getActionCommand()))
		{
			exit();
		}

		// Edit menu
		if ("Praca".equals(e.getActionCommand()))
		{
			Scanner sc = new Scanner("Adres pracy: Szczęsliwa 36");
			while (sc.hasNext())
			{
				ta.insert(sc.nextLine() + "\n", ta.getCaretPosition());
			}
			sc.close();
		}
		if ("Szkoła".equals(e.getActionCommand()))
		{
			Scanner sc = new Scanner("Adres szkoły: Udana 88");
			while (sc.hasNext())
			{
				ta.insert(sc.nextLine() + "\n", ta.getCaretPosition());
			}
			sc.close();
		}
		if ("Dom".equals(e.getActionCommand()))
		{
			Scanner sc = new Scanner("Adres domowy: Piękna 15");
			while (sc.hasNext())
			{
				ta.insert(sc.nextLine() + "\n", ta.getCaretPosition());
			}
			sc.close();
		}

		// Options menu

		for (int i = 0; i < colorsString.length; i++)
		{
			if (colorsString[i].equals(e.getActionCommand()))
			{
				ta.setBackground(colors[i]);
			}
		}
		for (int i = 0; i < fontsString.length; i++)
		{
			if ((fontsString[i]).equals(e.getActionCommand()))
			{
				ta.setFont(fonts[i]);
			}
		}
	}

	public void open()
	{
		JFileChooser fc = new JFileChooser();

		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			try
			{
				Scanner sc = new Scanner(file);
				while (sc.hasNext())
				{
					ta.append(sc.nextLine() + "\n");
				}
				sc.close();
			} catch (FileNotFoundException e1)
			{
				JOptionPane.showMessageDialog(null, "File not found: " + file,
						"Error", JOptionPane.ERROR_MESSAGE);
			}

			String filePath = file.toString();
			frame.setTitle("Prosty edytor - " + filePath);
		}
	}

	public void save()
	{
		JFileChooser fc = new JFileChooser();
		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			try
			{
				PrintWriter pw = new PrintWriter(file);
				Scanner sc = new Scanner(ta.getText());
				while (sc.hasNext())
					pw.println(sc.nextLine() + "\n");
				pw.close();
				sc.close();
			} catch (FileNotFoundException e1)
			{

			}
		}
	}
	public void saveas()
	{
		JFileChooser fc = new JFileChooser();

		if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File file = fc.getSelectedFile();
			try
			{
				PrintWriter pw = new PrintWriter(file);
				Scanner sc = new Scanner(ta.getText());
				while (sc.hasNext())
					pw.println(sc.nextLine() + "\n");
				pw.close();
				sc.close();
			} catch (FileNotFoundException e1)
			{

			}
		}
	}

	public void exit()
	{
		int choice = JOptionPane.showConfirmDialog(null,
				"Wyjść z Edytora? Niezapisane zmiany zostaną utracone!",
				"Wyjście z programu", 2);
		if (choice == JOptionPane.OK_OPTION)
		{
			System.exit(0);
		} else
		{
			return;
		}
	}

}
