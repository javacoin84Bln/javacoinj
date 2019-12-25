package com.javacoin.examples;

import com.javacoin.model.TransactionDecoded;
import com.javacoin.rpc.JavacoinRpc;
import com.javacoin.rpc.JavacoinRpcImpl;

public class TransactionDecodedExample extends ConnectionData {
	
	public static void main(String[] args) {

		JavacoinRpc javacoinRpc = new JavacoinRpcImpl(username, password, host, port);
		
		// change transaction hex
		TransactionDecoded TransDecoded =  javacoinRpc.decodeRawTransaction("0100000009c92ce02fa8e9dd24bf760314b4c9f277b132c3ba41017aa64066ff7ca2d54326000000006a47304402203d73416fee9170bd38c72851a7a2f9692726fcc620d9010c6fe7381df34b349d022008eeef5766ed6afb545fb3fb805183bd9c9a198688667c00f32659a8570626d1012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffffe9f74bf867024e896471c852e1965598597e8c207bfe0d1444ef285462246c05000000006b4830450220705b8e260850fefe02a86111f523fda3e5ccea6f310bccf0364228bc8fa8f5ea022100dee58ffed01c1c9c5a1e26f49fdef0d4402b9d0266b8cb0149fbb74f89d7e98a012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffff297f9eaf54096c959878019ac6755264188185121545cbf95d2703d943825422000000006b48304502203ffdcfdac2260a6b7380d94fea913e1051fdca7acd9baf7349f342e0dd8d439f022100fb027a3a58c2d95944eba4f625d01629169d1019b381973fdad5292383389baf012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffffc86e720727a89155431885c22402570f0b72b9e82610c3044a9cfabd7032f316000000006b483045022100d2aae3df12af212299c3ea1650c74651f016ad51d7935eb9d67db512d6d1927502205ce585af3a0f0930334779a6c4756347a94106486abed4602d4473bfa18beea5012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffff18acbc292d3908a98d61a94bee08174297c5587bb75e83fe195bedac470dd157000000006b483045022029f2c8393d7778b342e85b6c3310942cc215c62f7a869d059f1948b6cc1642b0022100c07ef92f49c45c98ea9bda60a0ce17530bb9f98b2143f66613573d15c088bb13012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffffd6ce739d2bded06642fe302fdcf63e1f8bf6f7578e39bffdf5f67a4935ed6578000000006b48304502207d5a059f235648e82d6e427745a726d2ef9aab7ac2d9c7ba8937f8bf3fc41454022100bff9b8e0e184d840b9643d4f58d9a6ccf9a23b370970abfd9626048666cebce2012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffff04b1e59933935a93256e69d16216b7339f03a46f07a53ac417c1ce76ca7c31cb000000006a47304402205fa66c833e5bbf000e0bd9b852687b8837af30ddc4368a29ebca26e5177da2cd02200ae55e5ef624589efaf5c0fe7242df5a4fd82ab7cdd91ab0f55b887d75acc4110121026c79bc007e0cb445c5716c2db0b89b2ace1036b876441bfc736c6008098b52fbffffffffaea299897fbc508cf569e9e4a0c70020ed513bc663142a668aa3c45ee4625d78000000006b483045022100ce7a78dd5bd7de26eec38a76b0b422de152309503e8560f18baf4e6f4f99ca16022035c2f9af1d12704b53805cea3b2f321aaf0e8deb1f858e92706196666fb92718012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffff552a51f19be75c661b380f10d8cbbd0f50bf20f5b8386d120f72bc0454e23bd2000000006b48304502206e8c6d03542f1e1fcf6e59b4e5ef7dc1c32b9e256ca047245feade78469c2ade022100cb5d5cd3273a11cb8ec73b1f1a6a53fee6a547c703a2d7db4069518344ee620e012103002ed7b027aa4c6e8bfc5436c0ab42807d3cb3ee8aa337fad0eef9b9cbd43a49ffffffff0221b41e07010000001976a914b682ac3f1bb28c792e2df84065a14fadf003b8e988acc01ca1029a0300001976a9144c0be359e68b997ee7553db186dbb06e41eeb28088ac00000000");
		System.out.println(TransDecoded);
		
		
	}

}
