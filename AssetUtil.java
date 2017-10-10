package functions;

import java.util.Arrays;
import java.util.List;

import functions.utils.Asset;
import functions.utils.Asset.AssetType;

public class AssetUtil {

	public static int totalAssetValues(final List<Asset> assets) {
		int total = 0;
		for (Asset asset : assets) {
			
			total += asset.getValue();
		}
		return total;
	}
	
	public static int totalStockValues(final List<Asset> assets) {
		int total = 0;
		for (Asset asset : assets) {
			if(asset.getType().equals(AssetType.STOCK))
			total += asset.getValue();
		}
		return total;
	}
	


	public static void main(final String[] args) {
		final List<Asset> assets = Arrays.asList(new Asset(
				Asset.AssetType.BOND, 1000), new Asset(Asset.AssetType.BOND,
				2000), new Asset(Asset.AssetType.STOCK, 3000), new Asset(
				Asset.AssetType.STOCK, 4000));

		System.out.println("//" + "START:TOTAL_ALL_OUTPUT");
		System.out.println("Total of all assets: " + totalAssetValues(assets));

	}
}
