package com.javacoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeerInfo {

	private String addr;
	private String services;
	private long lastsend;
	private long lastrecv;
	private int bytessent;
	private int bytesrecv;
	private int blocksrequested;
	private long conntime;
	private int version;
	private String subver;
	private boolean inbound;
	private int startingheight;
	private int banscore;
	private boolean syncnode;
}
