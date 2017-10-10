package functions;

import java.util.Arrays;
import java.util.List;

import functions.utils.Asset;
import functions.utils.Asset.AssetType;

/**
 * 
 * @author srinirag
 * 
 * 
 *         An explanation of the of the classic strategy pattern ;
 * 
 * 
 * 
 *         I have list of names
 * 
 *         i have to find the
 * 
 *
 */

interface StratergicTester<T> {

	boolean test(T t);
}

public class AssetUtilWithStratergy {

	

	public static int totalAssetValuesWithaStarategy(final List<Asset> assets,
			StratergicTester<Asset> tester) {
		int total = 0;
		for (Asset asset : assets) {
			if (tester.test(asset))
				total += asset.getValue();
		}
		return total;
	}

	public static void main(final String[] args) {
		final List<Asset> assets = Arrays.asList(new Asset(
				Asset.AssetType.BOND, 1000), new Asset(Asset.AssetType.BOND,
				2000), new Asset(Asset.AssetType.STOCK, 3000), new Asset(
				Asset.AssetType.STOCK, 4000));

		System.out.println("Total of all bonds: "
				+ totalAssetValuesWithaStarategy(assets,
						new StratergicTester<Asset>() {

							@Override
							public boolean test(Asset t) {

								return t.getType() == AssetType.BOND;
							}

						}));

		System.out.println("Total of all stocks: "
				+ totalAssetValuesWithaStarategy(assets,
						new StratergicTester<Asset>() {

							@Override
							public boolean test(Asset t) {

								return t.getType() == AssetType.STOCK;
							}

						}));

		System.out.println("//" + "END:TOTAL_ALL_OUTPUT");

	}
}
