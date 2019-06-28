package com.techlab.contact.frames;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.techlab.contact.Contact;
import com.techlab.contact.services.ContactServices;

public class DisplayContactFrame extends JFrame {
	private ContactServices contactServices = new ContactServices();
	private Font font = new Font("Arial", Font.PLAIN, 20);
	private ArrayList<Contact> contactList;

	public DisplayContactFrame() {

		try {
			contactList = contactServices.getContactList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String col[] = { "Name", "Email", "Phone" };
		DefaultTableModel tableModel = new DefaultTableModel(0, col.length);
		tableModel.setColumnIdentifiers(col);
		JTable table = new JTable(tableModel);
		for (int index = 0; index < contactList.size(); index++) {
			String name = contactList.get(index).getName();
			String email = contactList.get(index).getEmail();
			long number = contactList.get(index).getPhoneNo();

			Object[] data = { name, email, number };

			tableModel.addRow(data);
		}
		table.setBounds(0, 0, 800, 800);
		table.setRowHeight(25);
		table.setFont(font);
		JScrollPane sp = new JScrollPane(table);
		this.add(table);
		this.setSize(800, 800);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
