////////////////////////////////////////////////////////////////////////////////
///	@file			BlackJack.java
///	@brief			ブラックジャッククラス
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

////////////////////////////////////////////////////////////////////////////////
///	@class		BlackJack
///	@brief		ブラックジャッククラス
///
////////////////////////////////////////////////////////////////////////////////
public class BlackJack {
	public static final int DEF_SHUFFLE_CNT = 10;
	private TrumpCards trumpCards; //!< トランプカード
	private Player player; //!< プレイヤー
	private Player dealer; //!< ディーラー
	private boolean gameEndFlag; //!< ゲーム終了フラグ

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			コンストラクタ
	///	@fn				public BlackJack()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public BlackJack() {
		this.trumpCards = new TrumpCards(0);
		this.player = new Player();
		this.dealer = new Player();
		this.gameInit();
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				TrumpCards getTrumpCards()
	///	@return			トランプカード
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public TrumpCards getTrumpCards() {
		return trumpCards;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setTrumpCards(TrumpCards trumpCards)
	///	@param[in]		TrumpCards trumpCards	トランプカード
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setTrumpCards(TrumpCards trumpCards) {
		this.trumpCards = trumpCards;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public Player getPlayer()
	///	@return			プレイヤー
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public Player getPlayer() {
		return player;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setPlayer(Player player)
	///	@param[in]		Player player	プレイヤー
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setPlayer(Player player) {
		this.player = player;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public Player getDealer()
	///	@return			ディーラー
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public Player getDealer() {
		return dealer;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setDealer(Player dealer)
	///	@param[in]		Player dealer	ディーラー
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setDealer(Player dealer) {
		this.dealer = dealer;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public boolean getGameEndFlag()
	///	@return			ディーラー
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public boolean getGameEndFlag() {
		return gameEndFlag;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setGameEndFlag(boolean gameEndFlag)
	///	@param[in]		boolean gameEndFlag	ゲーム終了フラグ
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setGameEndFlag(boolean gameEndFlag) {
		this.gameEndFlag = gameEndFlag;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲーム初期化
	///	@fn				public void gameInit()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void gameInit() {
		this.gameEndFlag = false;
		// *** 山札シャッフル *** //
		for (int i = 0; i < DEF_SHUFFLE_CNT; i++) {
			this.trumpCards.shuffle();
		}
		// *** プレイヤー・ディーラー初期化 *** //
		this.player.setCards(new ArrayList<Card>());
		this.player.setCardsCnt(0);
		this.dealer.setCards(new ArrayList<Card>());
		this.dealer.setCardsCnt(0);
		// *** プレイヤー・ディーラー手札を2枚づつ配る *** //
		for (int i = 0; i < 2; i++) {
			this.player.getCards().add(this.trumpCards.drowCard());
			this.player.setCardsCnt(this.player.getCardsCnt() + 1);
			this.dealer.getCards().add(this.trumpCards.drowCard());
			this.dealer.setCardsCnt(this.dealer.getCardsCnt() + 1);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			プレイヤーヒット
	///	@fn				public void playerHit()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void playerHit() {
		if (this.gameEndFlag == false) {
			this.player.getCards().add(this.trumpCards.drowCard());
			this.player.setCardsCnt(this.player.getCardsCnt() + 1);
			int score = this.getScore(this.player.getCards(), this.player.getCardsCnt());
			if (22 <= score)
				this.playerStand(); // バーストしたので強制終了
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			プレイヤースタンド
	///	@fn				public void playerStand()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void playerStand() {
		this.dealerHit();
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ディーラーヒット
	///	@fn				private void dealerHit()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	private void dealerHit() {
		for (;;) {
			int score = this.getScore(this.dealer.getCards(), this.dealer.getCardsCnt());
			if (score < 17) {
				// *** ディーラーは自分の手持ちのカードの合計が「17」以上になるまで	  *** //
				// *** ヒットし続ける（カードを引き続ける）							*** //
				this.dealer.getCards().add(this.trumpCards.drowCard());
				this.dealer.setCardsCnt(this.dealer.getCardsCnt() + 1);
			} else {
				// *** ディーラーは自分の手持ちカードの合計が「17」以上になったら	  *** //
				// *** ステイする（カードを引かない）。								*** //
				this.dealerStand();
				break;
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ディーラースタンド
	///	@fn				private void dealerStand()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	private void dealerStand() {
		this.gameEndFlag = true;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			手札から現在のスコア取得
	///	@fn				public int getScore(ArrayList<Card> cards,int cardsCnt)
	///	@param[in]		ArrayList<Card> cards	手札
	///	@param[in]		int cardsCnt			手札枚数
	///	@return			現在のスコア
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int getScore(ArrayList<Card> cards, int cardsCnt) {
		int res = 0;
		boolean aceFlag = false;
		for (int i = 0; i < cardsCnt; i++) {
			if (2 <= cards.get(i).getValue() && cards.get(i).getValue() <= 10) {
				// *** 2～10 *** //
				res += cards.get(i).getValue();
			} else if (11 <= cards.get(i).getValue() && cards.get(i).getValue() <= 13) {
				// *** 11～13 *** //
				res += 10;
			} else {
				if (aceFlag) {
					// *** 2枚目のエースは強制的に1で換算する*** //
					res += 1;
				} else {
					// *** エースは後ほど計算する *** //
					aceFlag = true;
				}
			}
		}
		if (aceFlag) {
			// *** エース計算 *** //
			var tmpScore1 = res + 1;
			var tmpScore2 = res + 11;
			var diff1 = 21 - tmpScore1;
			var diff2 = 21 - tmpScore2;
			if ((22 <= tmpScore1) && (22 <= tmpScore2)) {
				// *** どちらもバーストしているならエースを1 *** //
				res = tmpScore1;
			} else if ((22 <= tmpScore1) && (tmpScore2 <= 21)) {
				// *** エースが1でバーストしているならエースを11 *** //
				res = tmpScore2;
			} else if ((tmpScore1 <= 21) && (22 <= tmpScore2)) {
				// *** エースが11でバーストしているならエースを1 *** //
				res = tmpScore1;
			} else {
				// *** どちらもバーストしていないなら21との差分が小さい方を採用 *** //
				if (diff1 < diff2)
					res = tmpScore1;
				else
					res = tmpScore2;
			}
		}
		return res;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲーム勝敗判定
	///	@fn				public int gameJudgment()
	///	@return			ゲーム勝敗判定
	///					- 1 : プレイヤーの勝利
	///					- 0 : 引き分け
	///					- -1 : プレイヤーの敗北
	///
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int gameJudgment() {
		int res = 0;
		int score1 = this.getScore(this.player.getCards(), this.player.getCardsCnt());
		int score2 = this.getScore(this.dealer.getCards(), this.dealer.getCardsCnt());
		int diff1 = 21 - score1;
		int diff2 = 21 - score2;
		if (22 <= score1 && 22 <= score2) {
			// *** プレイヤー・ディーラー共にバーストしているので負け *** //
			res = -1;
		} else if (22 <= score1 && score2 <= 21) {
			// *** プレイヤーバーストしているので負け *** //
			res = -1;
		} else if (score1 <= 21 && 22 <= score2) {
			// *** ディーラーバーストしているので勝ち *** //
			res = 1;
		} else {
			if (diff1 == diff2) {
				// *** 同スコアなら引き分け *** //
				res = 0;
				if (score1 == 21 && this.player.getCardsCnt() == 2 && this.dealer.getCardsCnt() != 2) {
					// *** プレイヤーのみがピュアブラックジャックならプレイヤーの勝ち *** //
					res = 1;
				}
			} else if (diff1 < diff2) {
				// *** プレイヤーの方が21に近いので勝ち *** //
				res = 1;
			} else {
				// *** ディーラーの方が21に近いので負け *** //
				res = -1;
			}
		}
		return res;
	}

}
