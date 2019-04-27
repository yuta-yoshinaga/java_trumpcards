////////////////////////////////////////////////////////////////////////////////
///	@file			TrumpCards.java
///	@brief			トランプカードクラス
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
import java.util.Collections;

////////////////////////////////////////////////////////////////////////////////
///	@class		TrumpCards
///	@brief		トランプカードクラス
///
////////////////////////////////////////////////////////////////////////////////
public class TrumpCards {
	public static final int DEF_CARD_CNT = (13 * 4);
	private ArrayList<Card> deck; //!< 山札
	private int deckDrowCnt; //!< 山札配った枚数
	private int deckCnt; //!< 山札枚数

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			コンストラクタ
	///	@fn				public TrumpCards(int jokerCnt)
	///	@param[in]		int jokerCnt		ジョーカー枚数
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public TrumpCards(int jokerCnt) {
		this.deckCnt = DEF_CARD_CNT + jokerCnt;
		this.cardsInit();
		this.deckInit();
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public ArrayList<Card> getDeck()
	///	@return			山札
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Card> getDeck() {
		return deck;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setDeck(ArrayList<Card> deck)
	///	@param[in]		ArrayList<Card> deck	山札
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public int getDeckDrowCnt()
	///	@return			山札配った枚数
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int getDeckDrowCnt() {
		return deckDrowCnt;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setDeckDrowCnt(int deckDrowCnt)
	///	@param[in]		int deckDrowCnt	山札配った枚数
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setDeckDrowCnt(int deckDrowCnt) {
		this.deckDrowCnt = deckDrowCnt;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public int getDeckCnt()
	///	@return			山札枚数
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int getDeckCnt() {
		return deckCnt;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setDeckCnt(int deckCnt)
	///	@param[in]		int deckCnt	山札枚数
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setDeckCnt(int deckCnt) {
		this.deckCnt = deckCnt;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			カード初期化
	///	@fn				private void cardsInit()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	private void cardsInit() {
		this.deck = new ArrayList<Card>();
		for (int i = 0; i < this.deckCnt; i++) {
			Card curCard = new Card();
			curCard.setDrowFlag(false);
			if (0 <= i && i <= 12) {
				// *** スペード *** //
				curCard.setType(Card.DEF_CARD_TYPE_SPADE);
				curCard.setValue(i + 1);
			} else if (13 <= i && i <= 25) {
				// *** クローバー *** //
				curCard.setType(Card.DEF_CARD_TYPE_CLOVER);
				curCard.setValue((i - 13) + 1);
			} else if (26 <= i && i <= 38) {
				// *** ハート *** //
				curCard.setType(Card.DEF_CARD_TYPE_HEART);
				curCard.setValue((i - 26) + 1);
			} else if (39 <= i && i <= 51) {
				// *** ダイアモンド *** //
				curCard.setType(Card.DEF_CARD_TYPE_DIAMOND);
				curCard.setValue((i - 39) + 1);
			} else {
				// *** ジョーカー *** //
				curCard.setType(Card.DEF_CARD_TYPE_JOKER);
				curCard.setValue((i - 52) + 1);
			}
			this.deck.add(curCard);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			山札初期化
	///	@fn				private void deckInit()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	private void deckInit() {
		this.deckDrowFlagInit();
		this.deckDrowCnt = 0;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			山札ドローフラグ初期化
	///	@fn				private deckDrowFlagInit(): void
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	private void deckDrowFlagInit() {
		for (int i = 0; i < this.deckCnt; i++) {
			this.deck.get(i).setDrowFlag(false);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			山札シャッフル
	///	@fn				public shuffle(): void
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void shuffle() {
		Collections.shuffle(this.deck);
		this.deckDrowFlagInit();
		this.deckDrowCnt = 0;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			山札配る
	///	@fn				public drowCard(): Card
	///	@return			カードクラス
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public Card drowCard() {
		Card res = null;
		if (this.deckDrowCnt < this.deckCnt) {
			this.deck.get(this.deckDrowCnt).setDrowFlag(true);
			res = this.deck.get(this.deckDrowCnt++);
		}
		return res;
	}

}
