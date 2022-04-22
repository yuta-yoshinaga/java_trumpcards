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
	/// @brief メインメソッド
	/// @fn public static void main(String[] args)
	/// @param[in] String[] args
	/// @return ありません
	/// @author Yuta Yoshinaga
	/// @date 2019.04.27
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
	/// @class ConstSentence
	/// @brief 定型文クラス
	///
	////////////////////////////////////////////////////////////////////////////////
	public class ConstSentence {
		private final static String DASHED_LINE = "----------";
		private final static String DEALER_SCORE = "dealer score ";
		private final static String PLAYER_SCORE = "player score ";
		private final static String COMMA = ",";
		private final static String ASTERISK = "*";
		private final static String WIN_MESSEGE = "You are the winner.";
		private final static String DRAW_MESSEGE = "It is a draw.";
		private final static String LOSE_MESSEGE = "It is your loss.";
	}

	////////////////////////////////////////////////////////////////////////////////
	/// @brief ステータス表示
	/// @fn public void showStatus(BlackJack blackJack)
	/// @param[in] BlackJack blackJack
	/// @return ありません
	/// @author Yuta Yoshinaga
	/// @date 2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void showStatus(BlackJack blackJack) {
		System.out.println(ConstSentence.DASHED_LINE);
		// dealer
		ArrayList<Card> dc = blackJack.getDealer().getCards();
		int dcc = blackJack.getDealer().getCardsCnt();
		System.out
				.println(ConstSentence.DEALER_SCORE + (blackJack.getGameEndFlag() ? blackJack.getScore(dc, dcc) : ""));
		String cardStr = "";
		if (blackJack.getGameEndFlag()) {
			for (int i = 0; i < dcc; i++) {
				if (i != 0)
					cardStr += ConstSentence.COMMA;
				cardStr += getCardStr(dc.get(i));
			}
		} else {
			cardStr = getCardStr(dc.get(0)) + ConstSentence.COMMA + ConstSentence.ASTERISK;
		}
		System.out.println(cardStr);
		System.out.println(ConstSentence.DASHED_LINE);
		// player
		ArrayList<Card> pc = blackJack.getPlayer().getCards();
		int pcc = blackJack.getPlayer().getCardsCnt();
		System.out.println(ConstSentence.PLAYER_SCORE + blackJack.getScore(pc, pcc));
		cardStr = "";
		for (int i = 0; i < pcc; i++) {
			if (i != 0)
				cardStr += ConstSentence.COMMA;
			cardStr += getCardStr(pc.get(i));
		}
		System.out.println(cardStr);
		System.out.println(ConstSentence.DASHED_LINE);
		if (blackJack.getGameEndFlag()) {
			if (blackJack.gameJudgment() == 1) {
				System.out.println(ConstSentence.WIN_MESSEGE);
			} else if (blackJack.gameJudgment() == 0) {
				System.out.println(ConstSentence.DRAW_MESSEGE);
			} else {
				System.out.println(ConstSentence.LOSE_MESSEGE);
			}
			System.out.println(ConstSentence.DASHED_LINE);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	/// @brief カード情報文字列取得
	/// @fn public String getCardStr(Card card)
	/// @param[in] Card card
	/// @return カード情報文字列取得
	/// @author Yuta Yoshinaga
	/// @date 2019.04.27
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
