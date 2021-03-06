package com.shopify.mobile.storefront.domain.models

import type.CurrencyCode

/**
 * ISO 3166-1 alpha-2 country codes with some differences.
 */
enum class CountryCode {
    /**
     * Afghanistan.
     */
    AF,

    /**
     * Aland Islands.
     */
    AX,

    /**
     * Albania.
     */
    AL,

    /**
     * Algeria.
     */
    DZ,

    /**
     * Andorra.
     */
    AD,

    /**
     * Angola.
     */
    AO,

    /**
     * Anguilla.
     */
    AI,

    /**
     * Antigua And Barbuda.
     */
    AG,

    /**
     * Argentina.
     */
    AR,

    /**
     * Armenia.
     */
    AM,

    /**
     * Aruba.
     */
    AW,

    /**
     * Australia.
     */
    AU,

    /**
     * Austria.
     */
    AT,

    /**
     * Azerbaijan.
     */
    AZ,

    /**
     * Bahamas.
     */
    BS,

    /**
     * Bahrain.
     */
    BH,

    /**
     * Bangladesh.
     */
    BD,

    /**
     * Barbados.
     */
    BB,

    /**
     * Belarus.
     */
    BY,

    /**
     * Belgium.
     */
    BE,

    /**
     * Belize.
     */
    BZ,

    /**
     * Benin.
     */
    BJ,

    /**
     * Bermuda.
     */
    BM,

    /**
     * Bhutan.
     */
    BT,

    /**
     * Bolivia.
     */
    BO,

    /**
     * Bosnia And Herzegovina.
     */
    BA,

    /**
     * Botswana.
     */
    BW,

    /**
     * Bouvet Island.
     */
    BV,

    /**
     * Brazil.
     */
    BR,

    /**
     * British Indian Ocean Territory.
     */
    IO,

    /**
     * Brunei.
     */
    BN,

    /**
     * Bulgaria.
     */
    BG,

    /**
     * Burkina Faso.
     */
    BF,

    /**
     * Burundi.
     */
    BI,

    /**
     * Cambodia.
     */
    KH,

    /**
     * Canada.
     */
    CA,

    /**
     * Cape Verde.
     */
    CV,

    /**
     * Caribbean Netherlands.
     */
    BQ,

    /**
     * Cayman Islands.
     */
    KY,

    /**
     * Central African Republic.
     */
    CF,

    /**
     * Chad.
     */
    TD,

    /**
     * Chile.
     */
    CL,

    /**
     * China.
     */
    CN,

    /**
     * Christmas Island.
     */
    CX,

    /**
     * Cocos (Keeling) Islands.
     */
    CC,

    /**
     * Colombia.
     */
    CO,

    /**
     * Comoros.
     */
    KM,

    /**
     * Congo.
     */
    CG,

    /**
     * Congo, The Democratic Republic Of The.
     */
    CD,

    /**
     * Cook Islands.
     */
    CK,

    /**
     * Costa Rica.
     */
    CR,

    /**
     * Croatia.
     */
    HR,

    /**
     * Cuba.
     */
    CU,

    /**
     * Curaçao.
     */
    CW,

    /**
     * Cyprus.
     */
    CY,

    /**
     * Czech Republic.
     */
    CZ,

    /**
     * Côte d'Ivoire.
     */
    CI,

    /**
     * Denmark.
     */
    DK,

    /**
     * Djibouti.
     */
    DJ,

    /**
     * Dominica.
     */
    DM,

    /**
     * Dominican Republic.
     */
    DO,

    /**
     * Ecuador.
     */
    EC,

    /**
     * Egypt.
     */
    EG,

    /**
     * El Salvador.
     */
    SV,

    /**
     * Equatorial Guinea.
     */
    GQ,

    /**
     * Eritrea.
     */
    ER,

    /**
     * Estonia.
     */
    EE,

    /**
     * Eswatini.
     */
    SZ,

    /**
     * Ethiopia.
     */
    ET,

    /**
     * Falkland Islands (Malvinas).
     */
    FK,

    /**
     * Faroe Islands.
     */
    FO,

    /**
     * Fiji.
     */
    FJ,

    /**
     * Finland.
     */
    FI,

    /**
     * France.
     */
    FR,

    /**
     * French Guiana.
     */
    GF,

    /**
     * French Polynesia.
     */
    PF,

    /**
     * French Southern Territories.
     */
    TF,

    /**
     * Gabon.
     */
    GA,

    /**
     * Gambia.
     */
    GM,

    /**
     * Georgia.
     */
    GE,

    /**
     * Germany.
     */
    DE,

    /**
     * Ghana.
     */
    GH,

    /**
     * Gibraltar.
     */
    GI,

    /**
     * Greece.
     */
    GR,

    /**
     * Greenland.
     */
    GL,

    /**
     * Grenada.
     */
    GD,

    /**
     * Guadeloupe.
     */
    GP,

    /**
     * Guatemala.
     */
    GT,

    /**
     * Guernsey.
     */
    GG,

    /**
     * Guinea.
     */
    GN,

    /**
     * Guinea Bissau.
     */
    GW,

    /**
     * Guyana.
     */
    GY,

    /**
     * Haiti.
     */
    HT,

    /**
     * Heard Island And Mcdonald Islands.
     */
    HM,

    /**
     * Holy See (Vatican City State).
     */
    VA,

    /**
     * Honduras.
     */
    HN,

    /**
     * Hong Kong.
     */
    HK,

    /**
     * Hungary.
     */
    HU,

    /**
     * Iceland.
     */
    IS,

    /**
     * India.
     */
    IN,

    /**
     * Indonesia.
     */
    ID,

    /**
     * Iran, Islamic Republic Of.
     */
    IR,

    /**
     * Iraq.
     */
    IQ,

    /**
     * Ireland.
     */
    IE,

    /**
     * Isle Of Man.
     */
    IM,

    /**
     * Israel.
     */
    IL,

    /**
     * Italy.
     */
    IT,

    /**
     * Jamaica.
     */
    JM,

    /**
     * Japan.
     */
    JP,

    /**
     * Jersey.
     */
    JE,

    /**
     * Jordan.
     */
    JO,

    /**
     * Kazakhstan.
     */
    KZ,

    /**
     * Kenya.
     */
    KE,

    /**
     * Kiribati.
     */
    KI,

    /**
     * Korea, Democratic People's Republic Of.
     */
    KP,

    /**
     * Kosovo.
     */
    XK,

    /**
     * Kuwait.
     */
    KW,

    /**
     * Kyrgyzstan.
     */
    KG,

    /**
     * Lao People's Democratic Republic.
     */
    LA,

    /**
     * Latvia.
     */
    LV,

    /**
     * Lebanon.
     */
    LB,

    /**
     * Lesotho.
     */
    LS,

    /**
     * Liberia.
     */
    LR,

    /**
     * Libyan Arab Jamahiriya.
     */
    LY,

    /**
     * Liechtenstein.
     */
    LI,

    /**
     * Lithuania.
     */
    LT,

    /**
     * Luxembourg.
     */
    LU,

    /**
     * Macao.
     */
    MO,

    /**
     * Madagascar.
     */
    MG,

    /**
     * Malawi.
     */
    MW,

    /**
     * Malaysia.
     */
    MY,

    /**
     * Maldives.
     */
    MV,

    /**
     * Mali.
     */
    ML,

    /**
     * Malta.
     */
    MT,

    /**
     * Martinique.
     */
    MQ,

    /**
     * Mauritania.
     */
    MR,

    /**
     * Mauritius.
     */
    MU,

    /**
     * Mayotte.
     */
    YT,

    /**
     * Mexico.
     */
    MX,

    /**
     * Moldova, Republic of.
     */
    MD,

    /**
     * Monaco.
     */
    MC,

    /**
     * Mongolia.
     */
    MN,

    /**
     * Montenegro.
     */
    ME,

    /**
     * Montserrat.
     */
    MS,

    /**
     * Morocco.
     */
    MA,

    /**
     * Mozambique.
     */
    MZ,

    /**
     * Myanmar.
     */
    MM,

    /**
     * Namibia.
     */
    NA,

    /**
     * Nauru.
     */
    NR,

    /**
     * Nepal.
     */
    NP,

    /**
     * Netherlands.
     */
    NL,

    /**
     * Netherlands Antilles.
     */
    AN,

    /**
     * New Caledonia.
     */
    NC,

    /**
     * New Zealand.
     */
    NZ,

    /**
     * Nicaragua.
     */
    NI,

    /**
     * Niger.
     */
    NE,

    /**
     * Nigeria.
     */
    NG,

    /**
     * Niue.
     */
    NU,

    /**
     * Norfolk Island.
     */
    NF,

    /**
     * North Macedonia.
     */
    MK,

    /**
     * Norway.
     */
    NO,

    /**
     * Oman.
     */
    OM,

    /**
     * Pakistan.
     */
    PK,

    /**
     * Palestinian Territory, Occupied.
     */
    PS,

    /**
     * Panama.
     */
    PA,

    /**
     * Papua New Guinea.
     */
    PG,

    /**
     * Paraguay.
     */
    PY,

    /**
     * Peru.
     */
    PE,

    /**
     * Philippines.
     */
    PH,

    /**
     * Pitcairn.
     */
    PN,

    /**
     * Poland.
     */
    PL,

    /**
     * Portugal.
     */
    PT,

    /**
     * Qatar.
     */
    QA,

    /**
     * Republic of Cameroon.
     */
    CM,

    /**
     * Reunion.
     */
    RE,

    /**
     * Romania.
     */
    RO,

    /**
     * Russia.
     */
    RU,

    /**
     * Rwanda.
     */
    RW,

    /**
     * Saint Barthélemy.
     */
    BL,

    /**
     * Saint Helena.
     */
    SH,

    /**
     * Saint Kitts And Nevis.
     */
    KN,

    /**
     * Saint Lucia.
     */
    LC,

    /**
     * Saint Martin.
     */
    MF,

    /**
     * Saint Pierre And Miquelon.
     */
    PM,

    /**
     * Samoa.
     */
    WS,

    /**
     * San Marino.
     */
    SM,

    /**
     * Sao Tome And Principe.
     */
    ST,

    /**
     * Saudi Arabia.
     */
    SA,

    /**
     * Senegal.
     */
    SN,

    /**
     * Serbia.
     */
    RS,

    /**
     * Seychelles.
     */
    SC,

    /**
     * Sierra Leone.
     */
    SL,

    /**
     * Singapore.
     */
    SG,

    /**
     * Sint Maarten.
     */
    SX,

    /**
     * Slovakia.
     */
    SK,

    /**
     * Slovenia.
     */
    SI,

    /**
     * Solomon Islands.
     */
    SB,

    /**
     * Somalia.
     */
    SO,

    /**
     * South Africa.
     */
    ZA,

    /**
     * South Georgia And The South Sandwich Islands.
     */
    GS,

    /**
     * South Korea.
     */
    KR,

    /**
     * South Sudan.
     */
    SS,

    /**
     * Spain.
     */
    ES,

    /**
     * Sri Lanka.
     */
    LK,

    /**
     * St. Vincent.
     */
    VC,

    /**
     * Sudan.
     */
    SD,

    /**
     * Suriname.
     */
    SR,

    /**
     * Svalbard And Jan Mayen.
     */
    SJ,

    /**
     * Sweden.
     */
    SE,

    /**
     * Switzerland.
     */
    CH,

    /**
     * Syria.
     */
    SY,

    /**
     * Taiwan.
     */
    TW,

    /**
     * Tajikistan.
     */
    TJ,

    /**
     * Tanzania, United Republic Of.
     */
    TZ,

    /**
     * Thailand.
     */
    TH,

    /**
     * Timor Leste.
     */
    TL,

    /**
     * Togo.
     */
    TG,

    /**
     * Tokelau.
     */
    TK,

    /**
     * Tonga.
     */
    TO,

    /**
     * Trinidad and Tobago.
     */
    TT,

    /**
     * Tunisia.
     */
    TN,

    /**
     * Turkey.
     */
    TR,

    /**
     * Turkmenistan.
     */
    TM,

    /**
     * Turks and Caicos Islands.
     */
    TC,

    /**
     * Tuvalu.
     */
    TV,

    /**
     * Uganda.
     */
    UG,

    /**
     * Ukraine.
     */
    UA,

    /**
     * United Arab Emirates.
     */
    AE,

    /**
     * United Kingdom.
     */
    GB,

    /**
     * United States.
     */
    US,

    /**
     * United States Minor Outlying Islands.
     */
    UM,

    /**
     * Uruguay.
     */
    UY,

    /**
     * Uzbekistan.
     */
    UZ,

    /**
     * Vanuatu.
     */
    VU,

    /**
     * Venezuela.
     */
    VE,

    /**
     * Vietnam.
     */
    VN,

    /**
     * Virgin Islands, British.
     */
    VG,

    /**
     * Wallis And Futuna.
     */
    WF,

    /**
     * Western Sahara.
     */
    EH,

    /**
     * Yemen.
     */
    YE,

    /**
     * Zambia.
     */
    ZM,

    /**
     * Zimbabwe.
     */
    ZW
}