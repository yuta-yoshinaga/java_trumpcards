////////////////////////////////////////////////////////////////////////////////
///	@file			BlackJackMain.java
///	@brief			ブラックジャックメインクラス
///	@author			Yuta Yoshinaga
///	@date			2019.04.27
///	$Version:		$
///	$Revision:		$
///
/// (c) 2019 Yuta Yoshinaga.
///
/// - 本ソフトウェアの一部又は全てを無断で複写複製（コピー）することは、
///   著作権侵害にあたりますので、これを禁止します。
/// - 本製品の使用に起因する侵害または特許権その他権利の侵害に関しては
///   当方は一切その責任を負いません。
///
////////////////////////////////////////////////////////////////////////////////
package jp.gr.java_conf.yuta_yoshinaga.java_trumpcards;

import java.util.ArrayList;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////
///	@class		BlackJackMain
///	@brief		ブラックジャックメインクラス
///
////////////////////////////////////////////////////////////////////////////////
public class BlackJackMain {

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			メインメソッド
	///	@fn				public static void main(String[] args)
	///	@param[in]		String[] args
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		BlackJackMain blackJackMain = new BlackJackMain();
		BlackJack blackJack = new BlackJack();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter a command.");
			System.out.println("q・・・quit");
			System.out.println("r・・・reset");
			System.out.println("h・・・hit");
			System.out.println("s・・・stand");
			blackJackMain.showStatus(blackJack);
			String inputStr = sc.nextLine();
			switch (inputStr) {
			case "q":
			case "quit":
				// quit
				System.out.println("bye.");
				sc.close();
				System.exit(0);
				break;
			case "r":
			case "reset":
				// reset
				blackJack.gameInit();
				break;
			case "h":
			case "hit":
				// hit
				blackJack.playerHit();
				break;
			case "s":
			case "stand":
				// stand
				blackJack.playerStand();
				break;
			default:
				// Unsupported command
				System.out.println("Unsupported command.");
				break;
			}
		}

	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ステータス表示
	///	@fn				public void showStatus(BlackJack blackJack)
	///	@param[in]		BlackJack blackJack
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void showStatus(BlackJack blackJack) {
		System.out.println("----------");
		// dealer
		ArrayList<Card> dc = blackJack.getDealer().getCards();
		int dcc = blackJack.getDealer().getCardsCnt();
		System.out.println("dealer score " + (blackJack.getGameEndFlag() ? blackJack.getScore(dc, dcc) : ""));
		String cardStr = "";
		if (blackJack.getGameEndFlag()) {
			for (int i = 0; i < dcc; i++) {
				if (i != 0)
					cardStr += ",";
				cardStr += getCardStr(dc.get(i));
			}
		} else {
			cardStr = getCardStr(dc.get(0)) + ",*";
		}
		System.out.println(cardStr);
		System.out.println("----------");
		// player
		ArrayList<Card> pc = blackJack.getPlayer().getCards();
		int pcc = blackJack.getPlayer().getCardsCnt();
		System.out.println("player score " + blackJack.getScore(pc, pcc));
		cardStr = "";
		for (int i = 0; i < pcc; i++) {
			if (i != 0)
				cardStr += ",";
			cardStr += getCardStr(pc.get(i));
		}
		System.out.println(cardStr);
		System.out.println("----------");
		if (blackJack.getGameEndFlag()) {
			if (blackJack.gameJudgment() == 1) {
				System.out.println("You are the winner.");
			} else if (blackJack.gameJudgment() == 0) {
				System.out.println("It is a draw.");
			} else {
				System.out.println("It is your loss.");
			}
			System.out.println("----------");
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			カード情報文字列取得
	///	@fn				public String getCardStr(Card card)
	///	@param[in]		Card card
	///	@return			カード情報文字列取得
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public String getCardStr(Card card) {
		String res = "";
		switch (card.getType()) {
		case Card.DEF_CARD_TYPE_SPADE:
			res = "SPADE ";
			break;
		case Card.DEF_CARD_TYPE_CLOVER:
			res = "CLOVER ";
			break;
		case Card.DEF_CARD_TYPE_HEART:
			res = "HEART ";
			break;
		case Card.DEF_CARD_TYPE_DIAMOND:
			res = "DIAMOND ";
			break;
		default:
			res = "Unsupported card";
			break;
		}
		res = res + card.getValue();
		return res;
	}
}
