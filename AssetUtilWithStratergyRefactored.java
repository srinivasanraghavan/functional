package functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import functions.utils.Asset;
import functions.utils.Asset.AssetType;

public class AssetUtilWithStratergyRefactored {
	public static int totalAssetValuesWithaStarategy(final List<Asset> assets,
			Predicate<Asset> tester) {	
		int total = 0;
		for (Asset asset : assets) {
			if (tester.test(asset))
				total += asset.getValue();
		}
		return total;

	}

	public static void main(final String[] args) {

		List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000), new Asset(
						Asset.AssetType.BOND, 2000), new Asset(
						Asset.AssetType.STOCK, 3000), new Asset(
						Asset.AssetType.STOCK, 4000));

		System.out.println("Total of all assets: "
				+ totalAssetValuesWithaStarategy(assets, asset -> true));

		System.out.println("Total of bonds: "
				+ totalAssetValuesWithaStarategy(assets,
						asset -> asset.getType() == AssetType.BOND));

		System.out.println("Total of stocks: "
				+ totalAssetValuesWithaStarategy(assets,
						asset -> asset.getType() == AssetType.STOCK));
	}

}
