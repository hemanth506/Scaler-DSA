import { RideAssetType } from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";

export class RideAsset extends GlobalClass {
    type: RideAssetType
    assetNumber: string
    constructor(type: RideAssetType, assetNumber: string) {
        super()
        this.type = type
        this.assetNumber = assetNumber
    }
}