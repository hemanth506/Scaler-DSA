import { GlobalClass } from "./GlobalClass";

export class Movie extends GlobalClass {
    _title: string
    _language: string

    constructor(id: string, title: string, language: string) {
        super(id)
        this._language = language
        this._title = title
    }
}