/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2019 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.addins.client.richeditor.base.constants;

import com.google.gwt.resources.client.TextResource;
import gwt.material.design.addins.client.richeditor.MaterialRichEditorClientBundle;

public enum RichEditorLanguage {
    AR_AR("ar-AR", MaterialRichEditorClientBundle.INSTANCE.ar_AR()),
    BG_BG("bg-BG", MaterialRichEditorClientBundle.INSTANCE.bg_BG()),
    CA_ES("ca-ES", MaterialRichEditorClientBundle.INSTANCE.ca_ES()),
    CS_CZ("cs-CZ", MaterialRichEditorClientBundle.INSTANCE.cs_CZ()),
    DA_DK("da-DK", MaterialRichEditorClientBundle.INSTANCE.da_DK()),
    DE_DE("de-DE", MaterialRichEditorClientBundle.INSTANCE.de_DE()),
    EL_GR("el-GR", MaterialRichEditorClientBundle.INSTANCE.el_GR()),
    EN_US("en-US", MaterialRichEditorClientBundle.INSTANCE.en_US()),
    ES_ES("es-ES", MaterialRichEditorClientBundle.INSTANCE.es_ES()),
    ES_EU("es-EU", MaterialRichEditorClientBundle.INSTANCE.es_EU()),
    FA_IR("fa-IR", MaterialRichEditorClientBundle.INSTANCE.fa_IR()),
    FI_FI("fi-FI", MaterialRichEditorClientBundle.INSTANCE.fi_FI()),
    FR_FR("fr-FR", MaterialRichEditorClientBundle.INSTANCE.fr_FR()),
    GL_ES("gl-ES", MaterialRichEditorClientBundle.INSTANCE.gl_ES()),
    HE_IL("he-IL", MaterialRichEditorClientBundle.INSTANCE.he_IL()),
    HR_HR("hr-HR", MaterialRichEditorClientBundle.INSTANCE.hr_HR()),
    HU_HU("hu-HU", MaterialRichEditorClientBundle.INSTANCE.hu_HU()),
    ID_ID("id-ID", MaterialRichEditorClientBundle.INSTANCE.id_ID()),
    IT_IT("it-IT", MaterialRichEditorClientBundle.INSTANCE.it_IT()),
    JA_JP("ja-JP", MaterialRichEditorClientBundle.INSTANCE.ja_JP()),
    KO_KR("ko-KR", MaterialRichEditorClientBundle.INSTANCE.ko_KR()),
    LT_LT("lt-LT", MaterialRichEditorClientBundle.INSTANCE.lt_LT()),
    LT_LV("lt-LV", MaterialRichEditorClientBundle.INSTANCE.lt_LV()),
    MN_MN("mn-MN", MaterialRichEditorClientBundle.INSTANCE.mn_MN()),
    NB_NO("nb-NO", MaterialRichEditorClientBundle.INSTANCE.nb_NO()),
    NL_NL("nl-NL", MaterialRichEditorClientBundle.INSTANCE.nl_NL()),
    PL_PL("pl-PL", MaterialRichEditorClientBundle.INSTANCE.pl_PL()),
    PT_BR("pt-BR", MaterialRichEditorClientBundle.INSTANCE.pt_BR()),
    PT_PT("pt-PT", MaterialRichEditorClientBundle.INSTANCE.pt_PT()),
    RO_RO("ro-RO", MaterialRichEditorClientBundle.INSTANCE.ro_RO()),
    RU_RU("ru-RU", MaterialRichEditorClientBundle.INSTANCE.ru_RU()),
    SK_SK("sk-SK", MaterialRichEditorClientBundle.INSTANCE.sk_SK()),
    SL_SI("sl-SI", MaterialRichEditorClientBundle.INSTANCE.sl_SI()),
    SR_RS("sr-RS", MaterialRichEditorClientBundle.INSTANCE.sr_RS()),
    SV_SE("sv-SE", MaterialRichEditorClientBundle.INSTANCE.sv_SE()),
    TA_IN("ta-IN", MaterialRichEditorClientBundle.INSTANCE.ta_IN()),
    TH_TH("th-TH", MaterialRichEditorClientBundle.INSTANCE.th_TH()),
    TR_TR("tr-TR", MaterialRichEditorClientBundle.INSTANCE.tr_TR()),
    UK_UA("uk-UA", MaterialRichEditorClientBundle.INSTANCE.uk_UA()),
    VI_VN("vi-VN", MaterialRichEditorClientBundle.INSTANCE.vi_VN()),
    ZH_CN("zh-CN", MaterialRichEditorClientBundle.INSTANCE.zh_CN()),
    ZH_TW("zh-TW", MaterialRichEditorClientBundle.INSTANCE.zh_TW());

    private final String code;
    private final TextResource js;

    RichEditorLanguage(String code, TextResource js) {
        this.code = code;
        this.js = js;
    }

    public String getCode() {
        return code;
    }

    public TextResource getJs() {
        return js;
    }
}
