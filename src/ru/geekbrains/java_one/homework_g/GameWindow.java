package ru.geekbrains.java_one.homework_g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
	private static final int WIN_WIDTH = 507;
	private static final int WIN_HEIGHT = 555;
	private static final int WIN_POSX = 650;
	private static final int WIN_POSY = 250;
	private final Map map;

	GameWindow() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // закрытие окна
		setSize(WIN_WIDTH, WIN_HEIGHT); // задается ширина, высота
		setLocation(WIN_POSX, WIN_POSY); // отступ от полей
		setResizable(false); // тут запрещает изменять размера окна
		setTitle("Tic Tac Toe"); // заголовок
		JButton btnStart = new JButton("Start"); // создание кнопки
		JButton btnExit = new JButton("Exit");
		JPanel panelBottom = new JPanel(new GridLayout(1, 2));
		panelBottom.add(btnStart);
		panelBottom.add(btnExit);
		Settings settings = new Settings(this);
		map = new Map();
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settings.setVisible(true);
			}
		});

		add(map, BorderLayout.CENTER);
		add(btnStart, BorderLayout.WEST); // добавление кнопок
		add(btnExit, BorderLayout.EAST);
		setVisible(true); // видимо или нет окно
	}

	void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLen){
		map.startNewGame(gameMode, fieldSizeX,fieldSizeY, winLen);
	} // метод вызывающий новую игру (именно это ООП)
}
