package asymmetric;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import util.CryptoTools;

public class RSA_ECB_NoPadding {
	public static void main(String[] args) throws Exception
	{
		//Assignment C
//		BigInteger n = new BigInteger("94587468335128982981605019776781234618384857805657005686084562260910788622013722070926491690843853690071248130134427832324966728582532832363221542231787068203763027067400082835394459857525017707284768411819006776211493735326500782954621660256501187035611332577696332459049538105669711385995976912007767106063");		
//		BigInteger e = new BigInteger("74327");
//		BigInteger d = new BigInteger("7289370196881601766768920490284861650464951706793000236386405648425161747775298344104658393385359209126267833888223695609366844098655240542152017354442883676634193191857568369042999854440242050353181703706753485749165295123694487676952198090537385200990850805837963871485320168470788328336240930212290450023");
//		BigInteger ct = new BigInteger("87014856975716299121085087309577038316883175412853820115551293556230488405826385706604303724175236985573832006395540199066061101502996745421485579743246846982636317440505885092956723199407403632041108913018671613508572002898008615700858579079601105011909417884801902333329415712320494308682279897714456370814");

		//M
		BigInteger n = new BigInteger("7392811037412414828887076941190994397480926696526812809326377665793019888924777347556347557150405654608172366417269347236944804024449393707356708169831707");
		BigInteger e = new BigInteger("101");
		BigInteger d = new BigInteger("3074238253181400225873833975544769947467316052021050871205028336270364706285479453533780147465616498088937754906905324467645862690238643788416891064938221");
		BigInteger c = new BigInteger("5960700013743749380663719455489588055241616939799875700243016697858856021474397270399057679147415360831543142252018192065946714397007018082354871040076668");

		byte[] ct = c.toByteArray();
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(n, e);
		RSAPrivateKeySpec privSpec = new RSAPrivateKeySpec(n, d);
		PublicKey pub = keyFactory.generatePublic(pubSpec);
		PrivateKey priv = keyFactory.generatePrivate(privSpec);
		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, priv);
		byte[] pt = cipher.doFinal(ct);
		System.out.println(new String(pt));

		//Assignment C Output: Meet at York Lanes
		//Assignment marked question (M) output: issue attorney candidate

	}
}