package com.shopify.mobile.basketball.storefront.domain.models

/**
 * Currency codes.
 */
enum class CurrencyCode {
    /**
     * United States Dollars (USD).
     */
    USD,

    /**
     * Euro (EUR).
     */
    EUR,

    /**
     * United Kingdom Pounds (GBP).
     */
    GBP,

    /**
     * Canadian Dollars (CAD).
     */
    CAD,

    /**
     * Afghan Afghani (AFN).
     */
    AFN,

    /**
     * Albanian Lek (ALL).
     */
    ALL,

    /**
     * Algerian Dinar (DZD).
     */
    DZD,

    /**
     * Angolan Kwanza (AOA).
     */
    AOA,

    /**
     * Argentine Pesos (ARS).
     */
    ARS,

    /**
     * Armenian Dram (AMD).
     */
    AMD,

    /**
     * Aruban Florin (AWG).
     */
    AWG,

    /**
     * Australian Dollars (AUD).
     */
    AUD,

    /**
     * Barbadian Dollar (BBD).
     */
    BBD,

    /**
     * Azerbaijani Manat (AZN).
     */
    AZN,

    /**
     * Bangladesh Taka (BDT).
     */
    BDT,

    /**
     * Bahamian Dollar (BSD).
     */
    BSD,

    /**
     * Bahraini Dinar (BHD).
     */
    BHD,

    /**
     * Burundian Franc (BIF).
     */
    BIF,

    /**
     * Belarusian Ruble (BYR).
     */
    @Deprecated(message =
    "`BYR` is deprecated. Use `BYN` available from version `2019-10` onwards instead.")
    BYR,

    /**
     * Belize Dollar (BZD).
     */
    BZD,

    /**
     * Bermudian Dollar (BMD).
     */
    BMD,

    /**
     * Bhutanese Ngultrum (BTN).
     */
    BTN,

    /**
     * Bosnia and Herzegovina Convertible Mark (BAM).
     */
    BAM,

    /**
     * Brazilian Real (BRL).
     */
    BRL,

    /**
     * Bolivian Boliviano (BOB).
     */
    BOB,

    /**
     * Botswana Pula (BWP).
     */
    BWP,

    /**
     * Brunei Dollar (BND).
     */
    BND,

    /**
     * Bulgarian Lev (BGN).
     */
    BGN,

    /**
     * Burmese Kyat (MMK).
     */
    MMK,

    /**
     * Cambodian Riel.
     */
    KHR,

    /**
     * Cape Verdean escudo (CVE).
     */
    CVE,

    /**
     * Cayman Dollars (KYD).
     */
    KYD,

    /**
     * Central African CFA Franc (XAF).
     */
    XAF,

    /**
     * Chilean Peso (CLP).
     */
    CLP,

    /**
     * Chinese Yuan Renminbi (CNY).
     */
    CNY,

    /**
     * Colombian Peso (COP).
     */
    COP,

    /**
     * Comorian Franc (KMF).
     */
    KMF,

    /**
     * Congolese franc (CDF).
     */
    CDF,

    /**
     * Costa Rican Colones (CRC).
     */
    CRC,

    /**
     * Croatian Kuna (HRK).
     */
    HRK,

    /**
     * Czech Koruny (CZK).
     */
    CZK,

    /**
     * Danish Kroner (DKK).
     */
    DKK,

    /**
     * Dominican Peso (DOP).
     */
    DOP,

    /**
     * East Caribbean Dollar (XCD).
     */
    XCD,

    /**
     * Egyptian Pound (EGP).
     */
    EGP,

    /**
     * Ethiopian Birr (ETB).
     */
    ETB,

    /**
     * CFP Franc (XPF).
     */
    XPF,

    /**
     * Fijian Dollars (FJD).
     */
    FJD,

    /**
     * Gambian Dalasi (GMD).
     */
    GMD,

    /**
     * Ghanaian Cedi (GHS).
     */
    GHS,

    /**
     * Guatemalan Quetzal (GTQ).
     */
    GTQ,

    /**
     * Guyanese Dollar (GYD).
     */
    GYD,

    /**
     * Georgian Lari (GEL).
     */
    GEL,

    /**
     * Haitian Gourde (HTG).
     */
    HTG,

    /**
     * Honduran Lempira (HNL).
     */
    HNL,

    /**
     * Hong Kong Dollars (HKD).
     */
    HKD,

    /**
     * Hungarian Forint (HUF).
     */
    HUF,

    /**
     * Icelandic Kronur (ISK).
     */
    ISK,

    /**
     * Indian Rupees (INR).
     */
    INR,

    /**
     * Indonesian Rupiah (IDR).
     */
    IDR,

    /**
     * Israeli New Shekel (NIS).
     */
    ILS,

    /**
     * Iraqi Dinar (IQD).
     */
    IQD,

    /**
     * Jamaican Dollars (JMD).
     */
    JMD,

    /**
     * Japanese Yen (JPY).
     */
    JPY,

    /**
     * Jersey Pound.
     */
    JEP,

    /**
     * Jordanian Dinar (JOD).
     */
    JOD,

    /**
     * Kazakhstani Tenge (KZT).
     */
    KZT,

    /**
     * Kenyan Shilling (KES).
     */
    KES,

    /**
     * Kuwaiti Dinar (KWD).
     */
    KWD,

    /**
     * Kyrgyzstani Som (KGS).
     */
    KGS,

    /**
     * Laotian Kip (LAK).
     */
    LAK,

    /**
     * Latvian Lati (LVL).
     */
    LVL,

    /**
     * Lebanese Pounds (LBP).
     */
    LBP,

    /**
     * Lesotho Loti (LSL).
     */
    LSL,

    /**
     * Liberian Dollar (LRD).
     */
    LRD,

    /**
     * Lithuanian Litai (LTL).
     */
    LTL,

    /**
     * Malagasy Ariary (MGA).
     */
    MGA,

    /**
     * Macedonia Denar (MKD).
     */
    MKD,

    /**
     * Macanese Pataca (MOP).
     */
    MOP,

    /**
     * Malawian Kwacha (MWK).
     */
    MWK,

    /**
     * Maldivian Rufiyaa (MVR).
     */
    MVR,

    /**
     * Mexican Pesos (MXN).
     */
    MXN,

    /**
     * Malaysian Ringgits (MYR).
     */
    MYR,

    /**
     * Mauritian Rupee (MUR).
     */
    MUR,

    /**
     * Moldovan Leu (MDL).
     */
    MDL,

    /**
     * Moroccan Dirham.
     */
    MAD,

    /**
     * Mongolian Tugrik.
     */
    MNT,

    /**
     * Mozambican Metical.
     */
    MZN,

    /**
     * Namibian Dollar.
     */
    NAD,

    /**
     * Nepalese Rupee (NPR).
     */
    NPR,

    /**
     * Netherlands Antillean Guilder.
     */
    ANG,

    /**
     * New Zealand Dollars (NZD).
     */
    NZD,

    /**
     * Nicaraguan Córdoba (NIO).
     */
    NIO,

    /**
     * Nigerian Naira (NGN).
     */
    NGN,

    /**
     * Norwegian Kroner (NOK).
     */
    NOK,

    /**
     * Omani Rial (OMR).
     */
    OMR,

    /**
     * Panamian Balboa (PAB).
     */
    PAB,

    /**
     * Pakistani Rupee (PKR).
     */
    PKR,

    /**
     * Papua New Guinean Kina (PGK).
     */
    PGK,

    /**
     * Paraguayan Guarani (PYG).
     */
    PYG,

    /**
     * Peruvian Nuevo Sol (PEN).
     */
    PEN,

    /**
     * Philippine Peso (PHP).
     */
    PHP,

    /**
     * Polish Zlotych (PLN).
     */
    PLN,

    /**
     * Qatari Rial (QAR).
     */
    QAR,

    /**
     * Romanian Lei (RON).
     */
    RON,

    /**
     * Russian Rubles (RUB).
     */
    RUB,

    /**
     * Rwandan Franc (RWF).
     */
    RWF,

    /**
     * Samoan Tala (WST).
     */
    WST,

    /**
     * Saudi Riyal (SAR).
     */
    SAR,

    /**
     * Sao Tome And Principe Dobra (STD).
     */
    STD,

    /**
     * Serbian dinar (RSD).
     */
    RSD,

    /**
     * Seychellois Rupee (SCR).
     */
    SCR,

    /**
     * Singapore Dollars (SGD).
     */
    SGD,

    /**
     * Sudanese Pound (SDG).
     */
    SDG,

    /**
     * Syrian Pound (SYP).
     */
    SYP,

    /**
     * South African Rand (ZAR).
     */
    ZAR,

    /**
     * South Korean Won (KRW).
     */
    KRW,

    /**
     * South Sudanese Pound (SSP).
     */
    SSP,

    /**
     * Solomon Islands Dollar (SBD).
     */
    SBD,

    /**
     * Sri Lankan Rupees (LKR).
     */
    LKR,

    /**
     * Surinamese Dollar (SRD).
     */
    SRD,

    /**
     * Swazi Lilangeni (SZL).
     */
    SZL,

    /**
     * Swedish Kronor (SEK).
     */
    SEK,

    /**
     * Swiss Francs (CHF).
     */
    CHF,

    /**
     * Taiwan Dollars (TWD).
     */
    TWD,

    /**
     * Thai baht (THB).
     */
    THB,

    /**
     * Tanzanian Shilling (TZS).
     */
    TZS,

    /**
     * Trinidad and Tobago Dollars (TTD).
     */
    TTD,

    /**
     * Tunisian Dinar (TND).
     */
    TND,

    /**
     * Turkish Lira (TRY).
     */
    TRY,

    /**
     * Turkmenistani Manat (TMT).
     */
    TMT,

    /**
     * Ugandan Shilling (UGX).
     */
    UGX,

    /**
     * Ukrainian Hryvnia (UAH).
     */
    UAH,

    /**
     * United Arab Emirates Dirham (AED).
     */
    AED,

    /**
     * Uruguayan Pesos (UYU).
     */
    UYU,

    /**
     * Uzbekistan som (UZS).
     */
    UZS,

    /**
     * Vanuatu Vatu (VUV).
     */
    VUV,

    /**
     * Venezuelan Bolivares (VEF).
     */
    VEF,

    /**
     * Vietnamese đồng (VND).
     */
    VND,

    /**
     * West African CFA franc (XOF).
     */
    XOF,

    /**
     * Yemeni Rial (YER).
     */
    YER,

    /**
     * Zambian Kwacha (ZMW).
     */
    ZMW
}