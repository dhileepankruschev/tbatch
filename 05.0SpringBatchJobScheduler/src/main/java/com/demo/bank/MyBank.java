package com.demo.bank;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.record.Record;
import com.demo.util.Printer;

@Service
public class MyBank {
	public static List<Record> fetchPendingTransactions(){
		List<Record> pendingRecords = new ArrayList<Record>();
		pendingRecords.add(new Record(1, "912455", "65214", 100));
		pendingRecords.add(new Record(2, "65214", "96325", 6112));
		pendingRecords.add(new Record(3, "965874", "874569", 62548));
		pendingRecords.add(new Record(4, "125887", "32015", 32558.02));
		return pendingRecords;
	}

	public static void startTransaction(Record record) {
		Printer.syso("Strat transaction for "+record);
		Printer.syso("Debit from "+record.getDebitAc());
		Printer.syso("Credit to "+record.getCreditAc());
		Printer.syso("Transfered amount "+record.getAmount());
		Printer.syso("Inserting this transaction in db");
		Printer.syso("End transaction\n\n");
	}
	
	
	
}
