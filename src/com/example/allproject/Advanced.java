package com.example.allproject;

import com.example.message.Approve;
import com.example.message.R;
import com.example.message.R.id;
import com.guozg.wheelview.views.ArrayWheelAdapter;
import com.guozg.wheelview.views.OnWheelChangedListener;
import com.guozg.wheelview.views.WheelView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Advanced extends Activity{

	EditText keyword,companyname;
	TextView district,province,stage,category,show,show1,show2,show3;
	ImageView found,back;
<<<<<<< HEAD
	String[] strings={"å·¥ä¸š","é…’åº—åŠé¤é¥®","å•†åŠ¡åŠå…¬","ä½å®…/ç»æµé€‚ç”¨ç”¨æˆ¿","å…¬ç”¨äº‹ä¸šè®¾æ–½","å…¶ä»–"};
	public String category1[] = new String[] {"åŒ—äº¬å¸‚","å¤©æ´¥å¸‚","ä¸Šæµ·å¸‚","é‡åº†å¸‚","æ²³åŒ—çœ","å±±è¥¿çœ","å†…è’™å¤çœ","è¾½å®çœ","å‰æ—çœ","é»‘é¾™æ±Ÿçœ","æ±Ÿè‹çœ","æµ™æ±Ÿçœ","å®‰å¾½çœ","ç¦å»ºçœ","é¦™æ¸¯ç‰¹åˆ«è¡Œæ”¿åŒº","æ¾³é—¨ç‰¹åˆ«è¡Œæ”¿åŒº","æ±Ÿè¥¿çœ","å±±ä¸œçœ","æ²³å—çœ","æ¹–åŒ—çœ","æ¹–å—çœ","å¹¿ä¸œçœ",
			"å¹¿è¥¿å£®æ—è‡ªæ²»åŒºçœ","å®å¤å›æ—è‡ªæ²»åŒº","é’æµ·çœ","æ–°ç–†ç»´å¾å°”è‡ªæ²»åŒº","è¥¿è—è‡ªæ²»åŒº","å°æ¹¾çœ","æµ·å—çœ","å››å·çœ","äº‘å—çœ","è´µå·çœ","é™•è¥¿çœ","ç”˜è‚ƒçœ" };
	   public String category2[] = new String[] {"åŒ—äº¬å¸‚","å¤©æ´¥å¸‚","ä¸Šæµ·å¸‚","é‡åº†å¸‚","çŸ³å®¶åº„å¸‚ ","å”å±±å¸‚","ç§¦çš‡å²›å¸‚","é‚¯éƒ¸å¸‚","é‚¢å°å¸‚","ä¿å®šå¸‚","å¼ å®¶å£å¸‚","æ‰¿å¾·å¸‚","æ²§å·å¸‚","å»ŠåŠå¸‚","è¡¡æ°´å¸‚",
	             "å¤ªåŸå¸‚","å¤§åŒå¸‚","é˜³æ³‰å¸‚","é•¿æ²»å¸‚","æ™‹åŸå¸‚","æœ”å·å¸‚","æ™‹ä¸­å¸‚","è¿åŸå¸‚","å¿»å·å¸‚","ä¸´æ±¾å¸‚","å•æ¢å¸‚", "å‘¼å’Œæµ©ç‰¹å¸‚","åŒ…å¤´å¸‚","ä¹Œæµ·å¸‚","èµ¤å³°å¸‚","é€šè¾½å¸‚","é„‚å°”å¤šæ–¯å¸‚","å‘¼ä¼¦è´å°”å¸‚","å·´å½¦æ·–å°”å¸‚","ä¹Œå…°å¯Ÿå¸ƒå¸‚","å…´å®‰ç›Ÿå¸‚","é”¡æ—éƒ­å‹’ç›Ÿå¸‚","é˜¿æ‹‰å–„ç›Ÿå¸‚",
	             "æ²ˆé˜³å¸‚","å¤§è¿å¸‚","éå±±å¸‚","æŠšé¡ºå¸‚","æœ¬æºªå¸‚","ä¸¹ä¸œå¸‚","é”¦å·å¸‚","è¥å£å¸‚","é˜œæ–°å¸‚","è¾½é˜³å¸‚","ç›˜é”¦å¸‚","é“å²­å¸‚","æœé˜³å¸‚","è‘«èŠ¦å²›å¸‚", "é•¿æ˜¥å¸‚","å‰æ—å¸‚","å››å¹³å¸‚","è¾½æºå¸‚","é€šåŒ–å¸‚","ç™½å±±å¸‚","æ¾åŸå¸‚","ç™½åŸå¸‚","å»¶è¾¹æœé²œæ—è‡ªæ²»å·",
	             "å“ˆå°”æ»¨å¸‚","é½é½å“ˆå°”å¸‚","é¸¡è¥¿å¸‚","é¹¤å²—å¸‚","åŒé¸­å±±å¸‚","å¤§åº†å¸‚","ä¼Šæ˜¥å¸‚","ä½³æœ¨æ–¯å¸‚","ä¸ƒå°æ²³å¸‚","ç‰¡ä¸¹æ±Ÿå¸‚","é»‘æ²³å¸‚","ç»¥åŒ–å¸‚","å¤§å…´å®‰å²­å¸‚","å—äº¬å¸‚","æ— é”¡å¸‚","å¾å·å¸‚","å¸¸å·å¸‚","è‹å·å¸‚","å—é€šå¸‚","è¿äº‘æ¸¯å¸‚","æ·®å®‰å¸‚","ç›åŸå¸‚","æ‰¬å·å¸‚","é•‡æ±Ÿå¸‚","æ³°å·å¸‚","å®¿è¿å¸‚",
	             "æ­å·å¸‚","å®æ³¢å¸‚","æ¸©å·å¸‚","å˜‰å…´å¸‚","æ¹–å·å¸‚","ç»å…´å¸‚","é‡‘åå¸‚","è¡¢å·å¸‚","èˆŸå±±å¸‚","å°å·å¸‚","ä¸½æ°´å¸‚", "åˆè‚¥å¸‚","å·¢æ¹–å¸‚","èŠœæ¹–å¸‚","èšŒåŸ å¸‚","æ·®å—å¸‚","é©¬éå±±å¸‚","æ·®åŒ—å¸‚","é“œé™µå¸‚","å®‰åº†å¸‚","é»„å±±å¸‚","æ»å·å¸‚","é˜œé˜³å¸‚","å®¿å·å¸‚","å…­å®‰å¸‚","äº³å·å¸‚","æ± å·å¸‚","å®£åŸå¸‚",
	             "ç¦å·å¸‚","å¦é—¨å¸‚","è†ç”°å¸‚","ä¸‰æ˜å¸‚","æ³‰å·å¸‚","æ¼³å·å¸‚","å—å¹³å¸‚","é¾™å²©å¸‚","å®å¾·å¸‚","å—æ˜Œå¸‚","å…±é’åŸå¸‚","æ™¯å¾·é•‡å¸‚","èä¹¡å¸‚","ä¹æ±Ÿå¸‚","æ–°ä½™å¸‚","é¹°æ½­å¸‚","èµ£å·å¸‚","å‰å®‰å¸‚","å®œæ˜¥å¸‚","æŠšå·å¸‚","ä¸Šé¥¶å¸‚","æµå—å¸‚","é’å²›å¸‚","æ·„åšå¸‚","æ£åº„å¸‚","ä¸œè¥å¸‚","çƒŸå°å¸‚","æ½åŠå¸‚",
	             "æµå®å¸‚","æ³°å®‰å¸‚","å¨æµ·å¸‚","æ—¥ç…§å¸‚","è±èŠœå¸‚","ä¸´æ²‚å¸‚","å¾·å·å¸‚","èŠåŸå¸‚","æ»¨å·å¸‚","èæ³½å¸‚", "éƒ‘å·å¸‚","å¼€å°å¸‚","æ´›é˜³å¸‚","å¹³é¡¶å±±å¸‚","å®‰é˜³å¸‚","é¹¤å£å¸‚","æ–°ä¹¡å¸‚","ç„¦ä½œå¸‚","æ¿®é˜³å¸‚","è®¸æ˜Œå¸‚","æ¼¯æ²³å¸‚","ä¸‰é—¨å³¡å¸‚","å—é˜³å¸‚","å•†ä¸˜å¸‚","ä¿¡é˜³å¸‚","å‘¨å£å¸‚","é©»é©¬åº—å¸‚",
	             "æ­¦æ±‰å¸‚","é»„çŸ³å¸‚","åå °å¸‚","å®œæ˜Œå¸‚","è¥„é˜³å¸‚","é„‚å·å¸‚","è†é—¨å¸‚","å­æ„Ÿå¸‚","è†å·å¸‚","é»„å†ˆå¸‚","å’¸å®å¸‚","éšå·å¸‚","æ©æ–½åœŸå®¶æ—è‹—æ—è‡ªæ²»å·","ä»™æ¡ƒå¸‚","æ½œæ±Ÿå¸‚","å¤©é—¨å¸‚","ç¥å†œæ¶æ—åŒº","é•¿æ²™å¸‚","æ ªæ´²å¸‚","æ¹˜æ½­å¸‚","è¡¡é˜³å¸‚","é‚µé˜³å¸‚","å²³é˜³å¸‚","å¸¸å¾·å¸‚",
	             "å¼ å®¶ç•Œå¸‚","ç›Šé˜³å¸‚","éƒ´å·å¸‚","æ°¸å·å¸‚","æ€€åŒ–å¸‚","å¨„åº•å¸‚","æ¹˜è¥¿åœŸå®¶æ—è‹—æ—è‡ªæ²»å·","å¹¿å·å¸‚","æ·±åœ³å¸‚","ç æµ·å¸‚","ä½›å±±å¸‚","æ±Ÿé—¨å¸‚","ä¸œèå¸‚","ä¸­å±±å¸‚","éŸ¶å…³å¸‚","è‚‡åº†å¸‚","æƒ å·å¸‚","æ¢…å·å¸‚","æ±•å¤´å¸‚","æ±•å°¾å¸‚","æ²³æºå¸‚","é˜³æ±Ÿå¸‚","æ¸…è¿œå¸‚","æ¹›æ±Ÿå¸‚","èŒ‚åå¸‚","æ½®å·å¸‚","æ­é˜³å¸‚","äº‘æµ®å¸‚",
	             "å—å®å¸‚","æŸ³å·å¸‚","æ¡‚æ—å¸‚","æ¢§å·å¸‚","åŒ—æµ·å¸‚","é˜²åŸæ¸¯","é’¦å·å¸‚","è´µæ¸¯å¸‚","ç‰æ—å¸‚","ç™¾è‰²å¸‚","è´ºå·å¸‚","æ²³æ± å¸‚","æ¥å®¾å¸‚","å´‡å·¦å¸‚", "æµ·å£å¸‚","ä¸‰äºšå¸‚","äº”æŒ‡å±±å¸‚","ç¼æµ·å¸‚","å„‹å·å¸‚","æ–‡æ˜Œå¸‚","ä¸‡å®å¸‚","ä¸œæ–¹å¸‚","ä¸‰æ²™å¸‚","å®šå®‰å¿","å±¯æ˜Œå¿","æ¾„è¿ˆå¿",
	             "ä¸´é«˜å¿","ç™½æ²™é»æ—è‡ªæ²»å¿","æ˜Œæ±Ÿé»æ—è‡ªæ²»å¿","ä¹ä¸œé»æ—è‡ªæ²»å¿","é™µæ°´é»æ—è‡ªæ²»å¿","ä¿äº­é»æ—è‹—æ—è‡ªæ²»å¿","ç¼ä¸­é»æ—è‹—æ—è‡ªæ²»å¿",
	             "æˆéƒ½å¸‚","è‡ªè´¡å¸‚","èµ„é˜³å¸‚","æ³¸å·å¸‚","å¾·é˜³å¸‚","ç»µé˜³å¸‚","å¹¿å…ƒå¸‚","é‚å®å¸‚","å†…æ±Ÿå¸‚","ä¹å±±å¸‚","å—å……å¸‚","çœ‰å±±å¸‚","å®œå®¾å¸‚","å¹¿å®‰å¸‚","è¾¾å·å¸‚","é›…å®‰å¸‚","å·´ä¸­å¸‚","æ”€æèŠ±å¸‚","ç”˜å­œå·å¸‚","å‡‰å±±å·","é˜¿åå·",
	             "æ˜†æ˜å¸‚","æ›²é–å¸‚","ç‰æºªå¸‚","ä¿å±±å¸‚","æ˜­é€šå¸‚","ä¸½æ±Ÿå¸‚","æ½½æ´±å¸‚","ä¸´æ²§å¸‚","æ¥šé›„å·","å¤§ç†å·","æ–‡å±±å·","è¥¿åŒç‰ˆçº³å·","çº¢æ²³å·","å¾·å®å·","æ€’æ±Ÿå·è¿ªåº†å·",
	             "è´µé˜³å¸‚","å…­ç›˜æ°´å¸‚","éµä¹‰å¸‚","å®‰é¡ºå¸‚","æ¯•èŠ‚å¸‚","é“œä»å¸‚","é»”å—å¸‚","å¸ƒä¾æ—è‹—æ—è‡ªæ²»å·","é»”è¥¿å—å¸ƒä¾æ—è‹—æ—è‡ªæ²»å·","é»”ä¸œå—è‹—æ—ä¾—æ—è‡ªæ²»å·",
	             "è¥¿å®‰å¸‚","é“œå·å¸‚","å®é¸¡å¸‚","å’¸é˜³å¸‚","æ¸­å—å¸‚","å»¶å®‰å¸‚","æ±‰ä¸­å¸‚","æ¦†æ—å¸‚","å®‰åº·å¸‚","å•†æ´›å¸‚", "å…°å·å¸‚","å˜‰å³ªå…³å¸‚","é‡‘æ˜Œå¸‚","ç™½é“¶å¸‚","å¤©æ°´å¸‚","æ­¦å¨å¸‚","å¼ æ–å¸‚","å¹³å‡‰å¸‚","é…’æ³‰å¸‚","åº†é˜³å¸‚","å®šè¥¿å¸‚","é™‡å—å¸‚","ä¸´å¤å›æ—è‡ªæ²»å·","ç”˜å—è—æ—è‡ªæ²»å·",
	             "é“¶å·å¸‚","çŸ³å˜´å±±å¸‚","å´å¿ å¸‚","å›ºåŸå¸‚","ä¸­å«å¸‚", "è¥¿å®å¸‚","æµ·ä¸œå¸‚","ç‰æ ‘è—æ—è‡ªæ²»å·","æµ·åŒ—è—æ—è‡ªæ²»å·","é»„å—è—æ—è‡ªæ²»å·","æµ·å—è—æ—è‡ªæ²»å·","æœæ´›è—æ—è‡ªæ²»å·","æµ·è¥¿è’™å¤æ—è‡ªæ²»å·",
	             "ä¹Œé²æœ¨é½å¸‚","å…‹æ‹‰ç›ä¾å¸‚","åé²ç•ªåœ°åŒºå¸‚","å“ˆå¯†åœ°åŒºå¸‚","æ˜Œå‰å›æ—è‡ªæ²»å·","åšå°”å¡”æ‹‰è’™å¤è‡ªæ²»å·","å·´éŸ³éƒ­æ¥è’™å¤è‡ªæ²»å·","é˜¿å…‹è‹åœ°åŒº","å…‹å­œå‹’è‹æŸ¯å°”å…‹å­œå·å–€ä»€åœ°åŒº","å’Œç”°åœ°åŒº","ä¼ŠçŠå“ˆè¨å…‹è‡ªæ²»å·","å¡”åŸåœ°åŒº","é˜¿å‹’æ³°åœ°åŒº",
	             "çŸ³æ²³å­å¸‚","é˜¿æ‹‰å°”å¸‚","å›¾æœ¨èˆ’å…‹å¸‚","äº”å®¶æ¸ å¸‚","åŒ—å±¯å¸‚","é“é—¨å…³å¸‚","åŒæ²³å¸‚","æ‹‰è¨å¸‚","æ˜Œéƒ½åœ°åŒºå¸‚","å±±å—åœ°åŒºå¸‚","æ—¥å–€åˆ™åœ°åŒº","é‚£æ›²åœ°åŒº","é˜¿é‡Œåœ°åŒº","æ—èŠåœ°åŒº",
	             "é¦™æ¸¯å²›","ä¹é¾™å¸‚","æ–°ç•Œå¸‚", "æ¾³é—¨åŠå²›","æ°¹ä»”å²›","è·¯ç¯å²›","è·¯æ°¹åŸ" };
=======
	String[] strings={"¹¤Òµ","¾Æµê¼°²ÍÒû","ÉÌÎñ°ì¹«","×¡Õ¬/¾­¼ÃÊÊÓÃÓÃ·¿","¹«ÓÃÊÂÒµÉèÊ©","ÆäËûkkk"};
	public String category1[] = new String[] {"±±¾©ÊĞ","Ìì½òÊĞ","ÉÏº£ÊĞ","ÖØÇìÊĞ","ºÓ±±Ê¡","É½Î÷Ê¡","ÄÚÃÉ¹ÅÊ¡","ÁÉÄşÊ¡","¼ªÁÖÊ¡","ºÚÁú½­Ê¡","½­ËÕÊ¡","Õã½­Ê¡","°²»ÕÊ¡","¸£½¨Ê¡","Ïã¸ÛÌØ±ğĞĞÕşÇø","°ÄÃÅÌØ±ğĞĞÕşÇø","½­Î÷Ê¡","É½¶«Ê¡","ºÓÄÏÊ¡","ºş±±Ê¡","ºşÄÏÊ¡","¹ã¶«Ê¡",
			"¹ãÎ÷×³×å×ÔÖÎÇøÊ¡","ÄşÏÄ»Ø×å×ÔÖÎÇø","Çàº£Ê¡","ĞÂ½®Î¬Îá¶û×ÔÖÎÇø","Î÷²Ø×ÔÖÎÇø","Ì¨ÍåÊ¡","º£ÄÏÊ¡","ËÄ´¨Ê¡","ÔÆÄÏÊ¡","¹óÖİÊ¡","ÉÂÎ÷Ê¡","¸ÊËàÊ¡" };
	   public String category2[] = new String[] {"±±¾©ÊĞ","Ìì½òÊĞ","ÉÏº£ÊĞ","ÖØÇìÊĞ","Ê¯¼Ò×¯ÊĞ ","ÌÆÉ½ÊĞ","ÇØ»ÊµºÊĞ","ºªµ¦ÊĞ","ĞÏÌ¨ÊĞ","±£¶¨ÊĞ","ÕÅ¼Ò¿ÚÊĞ","³ĞµÂÊĞ","²×ÖİÊĞ","ÀÈ·»ÊĞ","ºâË®ÊĞ",
	             "Ì«Ô­ÊĞ","´óÍ¬ÊĞ","ÑôÈªÊĞ","³¤ÖÎÊĞ","½ú³ÇÊĞ","Ë·ÖİÊĞ","½úÖĞÊĞ","ÔË³ÇÊĞ","ĞÃÖİÊĞ","ÁÙ·ÚÊĞ","ÂÀÁºÊĞ", "ºôºÍºÆÌØÊĞ","°üÍ·ÊĞ","ÎÚº£ÊĞ","³à·åÊĞ","Í¨ÁÉÊĞ","¶õ¶û¶àË¹ÊĞ","ºôÂ×±´¶ûÊĞ","°ÍÑåÄ×¶ûÊĞ","ÎÚÀ¼²ì²¼ÊĞ","ĞË°²ÃËÊĞ","ÎıÁÖ¹ùÀÕÃËÊĞ","°¢À­ÉÆÃËÊĞ",
	             "ÉòÑôÊĞ","´óÁ¬ÊĞ","°°É½ÊĞ","¸§Ë³ÊĞ","±¾ÏªÊĞ","µ¤¶«ÊĞ","½õÖİÊĞ","Óª¿ÚÊĞ","¸·ĞÂÊĞ","ÁÉÑôÊĞ","ÅÌ½õÊĞ","ÌúÁëÊĞ","³¯ÑôÊĞ","ºùÂ«µºÊĞ", "³¤´ºÊĞ","¼ªÁÖÊĞ","ËÄÆ½ÊĞ","ÁÉÔ´ÊĞ","Í¨»¯ÊĞ","°×É½ÊĞ","ËÉÔ­ÊĞ","°×³ÇÊĞ","ÑÓ±ß³¯ÏÊ×å×ÔÖÎÖİ",
	             "¹ş¶û±õÊĞ","ÆëÆë¹ş¶ûÊĞ","¼¦Î÷ÊĞ","º×¸ÚÊĞ","Ë«Ñ¼É½ÊĞ","´óÇìÊĞ","ÒÁ´ºÊĞ","¼ÑÄ¾Ë¹ÊĞ","ÆßÌ¨ºÓÊĞ","Äµµ¤½­ÊĞ","ºÚºÓÊĞ","Ëç»¯ÊĞ","´óĞË°²ÁëÊĞ","ÄÏ¾©ÊĞ","ÎŞÎıÊĞ","ĞìÖİÊĞ","³£ÖİÊĞ","ËÕÖİÊĞ","ÄÏÍ¨ÊĞ","Á¬ÔÆ¸ÛÊĞ","»´°²ÊĞ","ÑÎ³ÇÊĞ","ÑïÖİÊĞ","Õò½­ÊĞ","Ì©ÖİÊĞ","ËŞÇ¨ÊĞ",
	             "º¼ÖİÊĞ","Äş²¨ÊĞ","ÎÂÖİÊĞ","¼ÎĞËÊĞ","ºşÖİÊĞ","ÉÜĞËÊĞ","½ğ»ªÊĞ","áéÖİÊĞ","ÖÛÉ½ÊĞ","Ì¨ÖİÊĞ","ÀöË®ÊĞ", "ºÏ·ÊÊĞ","³²ºşÊĞ","ÎßºşÊĞ","°ö²ºÊĞ","»´ÄÏÊĞ","Âí°°É½ÊĞ","»´±±ÊĞ","Í­ÁêÊĞ","°²ÇìÊĞ","»ÆÉ½ÊĞ","³üÖİÊĞ","¸·ÑôÊĞ","ËŞÖİÊĞ","Áù°²ÊĞ","ÙñÖİÊĞ","³ØÖİÊĞ","Ğû³ÇÊĞ",
	             "¸£ÖİÊĞ","ÏÃÃÅÊĞ","ÆÎÌïÊĞ","ÈıÃ÷ÊĞ","ÈªÖİÊĞ","ÕÄÖİÊĞ","ÄÏÆ½ÊĞ","ÁúÑÒÊĞ","ÄşµÂÊĞ","ÄÏ²ıÊĞ","¹²Çà³ÇÊĞ","¾°µÂÕòÊĞ","Æ¼ÏçÊĞ","¾Å½­ÊĞ","ĞÂÓàÊĞ","Ó¥Ì¶ÊĞ","¸ÓÖİÊĞ","¼ª°²ÊĞ","ÒË´ºÊĞ","¸§ÖİÊĞ","ÉÏÈÄÊĞ","¼ÃÄÏÊĞ","ÇàµºÊĞ","×Í²©ÊĞ","Ôæ×¯ÊĞ","¶«ÓªÊĞ","ÑÌÌ¨ÊĞ","Î«·»ÊĞ",
	             "¼ÃÄşÊĞ","Ì©°²ÊĞ","Íşº£ÊĞ","ÈÕÕÕÊĞ","À³ÎßÊĞ","ÁÙÒÊÊĞ","µÂÖİÊĞ","ÁÄ³ÇÊĞ","±õÖİÊĞ","ºÊÔóÊĞ", "Ö£ÖİÊĞ","¿ª·âÊĞ","ÂåÑôÊĞ","Æ½¶¥É½ÊĞ","°²ÑôÊĞ","º×±ÚÊĞ","ĞÂÏçÊĞ","½¹×÷ÊĞ","å§ÑôÊĞ","Ğí²ıÊĞ","äğºÓÊĞ","ÈıÃÅÏ¿ÊĞ","ÄÏÑôÊĞ","ÉÌÇğÊĞ","ĞÅÑôÊĞ","ÖÜ¿ÚÊĞ","×¤ÂíµêÊĞ",
	             "ÎäººÊĞ","»ÆÊ¯ÊĞ","Ê®ÑßÊĞ","ÒË²ıÊĞ","ÏåÑôÊĞ","¶õÖİÊĞ","¾£ÃÅÊĞ","Ğ¢¸ĞÊĞ","¾£ÖİÊĞ","»Æ¸ÔÊĞ","ÏÌÄşÊĞ","ËæÖİÊĞ","¶÷Ê©ÍÁ¼Ò×åÃç×å×ÔÖÎÖİ","ÏÉÌÒÊĞ","Ç±½­ÊĞ","ÌìÃÅÊĞ","ÉñÅ©¼ÜÁÖÇø","³¤É³ÊĞ","ÖêÖŞÊĞ","ÏæÌ¶ÊĞ","ºâÑôÊĞ","ÉÛÑôÊĞ","ÔÀÑôÊĞ","³£µÂÊĞ",
	             "ÕÅ¼Ò½çÊĞ","ÒæÑôÊĞ","³»ÖİÊĞ","ÓÀÖİÊĞ","»³»¯ÊĞ","Â¦µ×ÊĞ","ÏæÎ÷ÍÁ¼Ò×åÃç×å×ÔÖÎÖİ","¹ãÖİÊĞ","ÉîÛÚÊĞ","Öéº£ÊĞ","·ğÉ½ÊĞ","½­ÃÅÊĞ","¶«İ¸ÊĞ","ÖĞÉ½ÊĞ","ÉØ¹ØÊĞ","ÕØÇìÊĞ","»İÖİÊĞ","Ã·ÖİÊĞ","ÉÇÍ·ÊĞ","ÉÇÎ²ÊĞ","ºÓÔ´ÊĞ","Ñô½­ÊĞ","ÇåÔ¶ÊĞ","Õ¿½­ÊĞ","Ã¯ÃûÊĞ","³±ÖİÊĞ","½ÒÑôÊĞ","ÔÆ¸¡ÊĞ",
	             "ÄÏÄşÊĞ","ÁøÖİÊĞ","¹ğÁÖÊĞ","ÎàÖİÊĞ","±±º£ÊĞ","·À³Ç¸Û","ÇÕÖİÊĞ","¹ó¸ÛÊĞ","ÓñÁÖÊĞ","°ÙÉ«ÊĞ","ºØÖİÊĞ","ºÓ³ØÊĞ","À´±öÊĞ","³ç×óÊĞ", "º£¿ÚÊĞ","ÈıÑÇÊĞ","ÎåÖ¸É½ÊĞ","Çíº£ÊĞ","ÙÙÖİÊĞ","ÎÄ²ıÊĞ","ÍòÄşÊĞ","¶«·½ÊĞ","ÈıÉ³ÊĞ","¶¨°²ÏØ","ÍÍ²ıÏØ","³ÎÂõÏØ",
	             "ÁÙ¸ßÏØ","°×É³Àè×å×ÔÖÎÏØ","²ı½­Àè×å×ÔÖÎÏØ","ÀÖ¶«Àè×å×ÔÖÎÏØ","ÁêË®Àè×å×ÔÖÎÏØ","±£Í¤Àè×åÃç×å×ÔÖÎÏØ","ÇíÖĞÀè×åÃç×å×ÔÖÎÏØ",
	             "³É¶¼ÊĞ","×Ô¹±ÊĞ","×ÊÑôÊĞ","ãòÖİÊĞ","µÂÑôÊĞ","ÃàÑôÊĞ","¹ãÔªÊĞ","ËìÄşÊĞ","ÄÚ½­ÊĞ","ÀÖÉ½ÊĞ","ÄÏ³äÊĞ","Ã¼É½ÊĞ","ÒË±öÊĞ","¹ã°²ÊĞ","´ïÖİÊĞ","ÑÅ°²ÊĞ","°ÍÖĞÊĞ","ÅÊÖ¦»¨ÊĞ","¸Ê×ÎÖİÊĞ","Á¹É½Öİ","°¢°ÓÖİ",
	             "À¥Ã÷ÊĞ","Çú¾¸ÊĞ","ÓñÏªÊĞ","±£É½ÊĞ","ÕÑÍ¨ÊĞ","Àö½­ÊĞ","ª¶ıÊĞ","ÁÙ²×ÊĞ","³şĞÛÖİ","´óÀíÖİ","ÎÄÉ½Öİ","Î÷Ë«°æÄÉÖİ","ºìºÓÖİ","µÂºêÖİ","Å­½­ÖİµÏÇìÖİ",
	             "¹óÑôÊĞ","ÁùÅÌË®ÊĞ","×ñÒåÊĞ","°²Ë³ÊĞ","±Ï½ÚÊĞ","Í­ÈÊÊĞ","Ç­ÄÏÊĞ","²¼ÒÀ×åÃç×å×ÔÖÎÖİ","Ç­Î÷ÄÏ²¼ÒÀ×åÃç×å×ÔÖÎÖİ","Ç­¶«ÄÏÃç×å¶±×å×ÔÖÎÖİ",
	             "Î÷°²ÊĞ","Í­´¨ÊĞ","±¦¼¦ÊĞ","ÏÌÑôÊĞ","Î¼ÄÏÊĞ","ÑÓ°²ÊĞ","ººÖĞÊĞ","ÓÜÁÖÊĞ","°²¿µÊĞ","ÉÌÂåÊĞ", "À¼ÖİÊĞ","¼ÎÓø¹ØÊĞ","½ğ²ıÊĞ","°×ÒøÊĞ","ÌìË®ÊĞ","ÎäÍşÊĞ","ÕÅÒ´ÊĞ","Æ½Á¹ÊĞ","¾ÆÈªÊĞ","ÇìÑôÊĞ","¶¨Î÷ÊĞ","Â¤ÄÏÊĞ","ÁÙÏÄ»Ø×å×ÔÖÎÖİ","¸ÊÄÏ²Ø×å×ÔÖÎÖİ",
	             "Òø´¨ÊĞ","Ê¯×ìÉ½ÊĞ","ÎâÖÒÊĞ","¹ÌÔ­ÊĞ","ÖĞÎÀÊĞ", "Î÷ÄşÊĞ","º£¶«ÊĞ","ÓñÊ÷²Ø×å×ÔÖÎÖİ","º£±±²Ø×å×ÔÖÎÖİ","»ÆÄÏ²Ø×å×ÔÖÎÖİ","º£ÄÏ²Ø×å×ÔÖÎÖİ","¹ûÂå²Ø×å×ÔÖÎÖİ","º£Î÷ÃÉ¹Å×å×ÔÖÎÖİ",
	             "ÎÚÂ³Ä¾ÆëÊĞ","¿ËÀ­ÂêÒÀÊĞ","ÍÂÂ³·¬µØÇøÊĞ","¹şÃÜµØÇøÊĞ","²ı¼ª»Ø×å×ÔÖÎÖİ","²©¶ûËşÀ­ÃÉ¹Å×ÔÖÎÖİ","°ÍÒô¹ùÀãÃÉ¹Å×ÔÖÎÖİ","°¢¿ËËÕµØÇø","¿Ë×ÎÀÕËÕ¿Â¶û¿Ë×ÎÖİ¿¦Ê²µØÇø","ºÍÌïµØÇø","ÒÁÀç¹şÈø¿Ë×ÔÖÎÖİ","Ëş³ÇµØÇø","°¢ÀÕÌ©µØÇø",
	             "Ê¯ºÓ×ÓÊĞ","°¢À­¶ûÊĞ","Í¼Ä¾Êæ¿ËÊĞ","Îå¼ÒÇşÊĞ","±±ÍÍÊĞ","ÌúÃÅ¹ØÊĞ","Ë«ºÓÊĞ","À­ÈøÊĞ","²ı¶¼µØÇøÊĞ","É½ÄÏµØÇøÊĞ","ÈÕ¿¦ÔòµØÇø","ÄÇÇúµØÇø","°¢ÀïµØÇø","ÁÖÖ¥µØÇø",
	             "Ïã¸Ûµº","¾ÅÁúÊĞ","ĞÂ½çÊĞ", "°ÄÃÅ°ëµº","šë×Ğµº","Â·»·µº","Â·šë³Ç" };
>>>>>>> origin/master
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity__advanced);
		
		keyword=(EditText) findViewById(id.keyword);//é¡¹ç›®å…³é”®å­—
		companyname=(EditText) findViewById(id.companyname);//å…¬å¸åç§°
		district=(TextView) findViewById(id.district);//åŒºåŸŸ
		province=(TextView) findViewById(id.province);//çœä»½
		stage=(TextView) findViewById(id.stage);//é¡¹ç›®é˜¶æ®µ
		category=(TextView) findViewById(id.category);//é¡¹ç›®ç±»åˆ«
		found=(ImageView) findViewById(id.found);//ç¡®å®šæŸ¥æ‰¾
		back=(ImageView) findViewById(id.back);//è¿”å›
		show=(TextView) findViewById(id.show);
		show1=(TextView) findViewById(id.show1);
		show2=(TextView) findViewById(id.show2);
		show3=(TextView) findViewById(id.show3);
		
		//å»æ‰è¾¹æ¡†
		keyword.setBackgroundDrawable(null);
		companyname.setBackgroundDrawable(null);
		
		
		//ç¡®å®šæŸ¥æ‰¾
		found.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
				
			final String companystringString=companyname.getText().toString();
			if(companystringString.equals("")){
				Toast.makeText(Advanced.this,"è¯·è¾“å…¥å…¬å¸ç›¸å…³ä¿¡æ¯",Toast.LENGTH_SHORT).show();
			}
			final String keywordstringString=keyword.getText().toString();
			if(keywordstringString.equals("")){
				Toast.makeText(Advanced.this,"è¯·è¾“å…¥å…³é”®å­—",Toast.LENGTH_SHORT).show();
			}
			 if(!keywordstringString.equals("")&&!companystringString.equals("")){
				Intent intent=new Intent(Advanced.this,Searchresult.class);
				startActivity(intent);
				finish();
			 }	
			}
		});
		
		
	
		
		//åŒºåŸŸ
		district.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
				showSelectDialog(Advanced.this, "åŒºåŸŸé€‰æ‹©", category1);

	           }
	        });	 
			}

			private void showSelectDialog(Advanced advanced, String string,final String[] category1) {
				// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
				 AlertDialog dialog = new AlertDialog.Builder(advanced).create();
			        dialog.setTitle(string);
			        LinearLayout llContent = new LinearLayout(advanced);
			        llContent.setOrientation(LinearLayout.HORIZONTAL);
			        
			        //ç¬¬ä¸€çº§åˆ—è¡¨
			        final WheelView wheelLeft = new WheelView(advanced);
			        wheelLeft.setVisibleItems(5);
			        wheelLeft.setCyclic(true);
			        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(category1));
			        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
			        paramsLeft.gravity = Gravity.RIGHT;
			       
			        llContent.addView(wheelLeft, paramsLeft);
			        
			        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "ç¡®å®š", new DialogInterface.OnClickListener() {
			            @Override
			            public void onClick(DialogInterface dialog, int which) {
			                int leftPosition = wheelLeft.getCurrentItem();
			                String vLeft = category1[leftPosition];
			                show.setText(vLeft);
			                dialog.dismiss();
			            }
			        });
			        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "å–æ¶ˆ", new DialogInterface.OnClickListener() {
			            @Override
			            public void onClick(DialogInterface dialog, int which) {
			                dialog.dismiss();
			            }
			        });
			        dialog.setView(llContent);
			        if (!dialog.isShowing()) {
			            dialog.show();
			        }
		
			 	   //åŸå¸‚
				      province.setOnClickListener(new OnClickListener() {
					
			  		@Override
				    	public void onClick(View arg0) {
						// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
						
			  			showSelectDialog1(Advanced.this, "åŒºåŸŸé€‰æ‹©", category2);	
			  	
			 	           }
				        });	
					}

						private void showSelectDialog1(Advanced advanced,	String string, final String[] category1) {
							// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
							  AlertDialog dialog = new AlertDialog.Builder(advanced).create();
						        dialog.setTitle(string);
						        LinearLayout llContent = new LinearLayout(advanced);
						        llContent.setOrientation(LinearLayout.HORIZONTAL);
						        
						        //ç¬¬ä¸€çº§åˆ—è¡¨
						        final WheelView wheelLeft = new WheelView(advanced);
						        wheelLeft.setVisibleItems(5);
						        wheelLeft.setCyclic(true);
						        wheelLeft.setAdapter(new ArrayWheelAdapter<String>(category1));
						        LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,   LayoutParams.WRAP_CONTENT,(float)1 );
						        paramsLeft.gravity = Gravity.RIGHT;
						       
						        llContent.addView(wheelLeft, paramsLeft);
						        
						        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "ç¡®å®š", new DialogInterface.OnClickListener() {
						            @Override
						            public void onClick(DialogInterface dialog, int which) {
						                int leftPosition = wheelLeft.getCurrentItem();
						                String vLeft = category1[leftPosition];
						                show1.setText(vLeft);
						                dialog.dismiss();
						            }
						        });
						        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "å–æ¶ˆ", new DialogInterface.OnClickListener() {
						            @Override
						            public void onClick(DialogInterface dialog, int which) {
						                dialog.dismiss();
						            }
						        });
						        dialog.setView(llContent);
						        if (!dialog.isShowing()) {
						            dialog.show();
						        }
  
			        
			        
			        
					//é¡¹ç›®é˜¶æ®µ
					stage.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
						
						AlertDialog.Builder builder=new AlertDialog.Builder(Advanced.this);	
						builder.setItems(strings, new AlertDialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
								for(int i=0;i<strings.length;i++){
									if(i==arg1){
							
					                  show2.setText(strings[arg1]);	
					                  arg0.dismiss();
									 }
								  }
						      }
						  });
						builder.show();
						}
					});
					
					//é¡¹ç›®ç±»åˆ«
			           category.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
						
						AlertDialog.Builder builder=new AlertDialog.Builder(Advanced.this);	
						builder.setItems(strings, new AlertDialog.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
								for(int i=0;i<strings.length;i++){
									if(i==arg1){
							
					                  show3.setText(strings[arg1]);	
					                  arg0.dismiss();
									}}
						      }
						  });
						builder.show();
						}
					});
           
	 }	 
		//è®¾ç½®è¿”å›é”®
			@Override
			public void onBackPressed() {
				// TODO è‡ªåŠ¨ç”Ÿæˆçš„æ–¹æ³•å­˜æ ¹
				
			Intent intent=new Intent(Advanced.this,Choosemenu.class);
			startActivity(intent);
			finish();
				
			}			
}
