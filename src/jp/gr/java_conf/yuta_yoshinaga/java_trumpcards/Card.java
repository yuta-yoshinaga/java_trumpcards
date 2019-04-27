////////////////////////////////////////////////////////////////////////////////
///	@file			Card.java
///	@brief			カードクラス
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

////////////////////////////////////////////////////////////////////////////////
///	@class		Card
///	@brief		カードクラス
///
////////////////////////////////////////////////////////////////////////////////
public class Card {
	public static final int DEF_CARD_TYPE_JOKER = 0;
	public static final int DEF_CARD_TYPE_SPADE = 1;
	public static final int DEF_CARD_TYPE_CLOVER = 2;
	public static final int DEF_CARD_TYPE_HEART = 3;
	public static final int DEF_CARD_TYPE_DIAMOND = 4;
	public static final int DEF_CARD_TYPE_MIN = DEF_CARD_TYPE_JOKER;
	public static final int DEF_CARD_TYPE_MAX = DEF_CARD_TYPE_DIAMOND;

	public static final int DEF_CARD_VALUE_JOKER = 0;
	public static final int DEF_CARD_VALUE_MIN = 0;
	public static final int DEF_CARD_VALUE_MAX = 13;

	private int type;										//!< カード種類
	private int value;										//!< カード値
	private boolean drowFlag;								//!< カード払い出しフラグ
	private String ext;									//!< カード拡張情報など(カード別にメッセージを出す場合など)

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			コンストラクタ
	///	@fn				public Card()
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public Card()
	{
		this.type = DEF_CARD_TYPE_JOKER;
		this.value = DEF_CARD_VALUE_JOKER;
		this.drowFlag = false;
		this.ext = "";
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public int getType()
	///	@return			カード種類
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int getType() {
		return type;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setType(int type)
	///	@param[in]		int type		カード種類
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setType(int type) {
		this.type = type;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public getValue(): number
	///	@return			カード値
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public int getValue() {
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setValue(int value)
	///	@param[in]		int value		カード値
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setValue(int value) {
		this.value = value;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public boolean getDrowFlag()
	///	@return			カード払い出しフラグ
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public boolean getDrowFlag() {
		return drowFlag;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setDrowFlag(boolean drowFlag)
	///	@param[in]		boolean drowFlag		カード払い出しフラグ
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setDrowFlag(boolean drowFlag) {
		this.drowFlag = drowFlag;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			ゲッター
	///	@fn				public String getExt()
	///	@return			カード払い出しフラグ
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public String getExt() {
		return ext;
	}

	////////////////////////////////////////////////////////////////////////////////
	///	@brief			セッター
	///	@fn				public void setExt(String ext)
	///	@param[in]		String ext		カード拡張情報など(カード別にメッセージを出す場合など)
	///	@return			ありません
	///	@author			Yuta Yoshinaga
	///	@date			2019.04.27
	///
	////////////////////////////////////////////////////////////////////////////////
	public void setExt(String ext) {
		this.ext = ext;
	}

}
