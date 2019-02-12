/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gwt.material.design.addins.client.richeditor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Client Bundle for Rich Editor component
 *
 * @author kevzlou7979
 */
public interface MaterialRichEditorClientBundle extends ClientBundle {

    MaterialRichEditorClientBundle INSTANCE = GWT.create(MaterialRichEditorClientBundle.class);

    @Source("resources/js/material_note.min.js")
    TextResource richEditorJs();

    @Source("resources/css/material_note.min.css")
    TextResource richEditorCss();

    @Source("resources/js/materialnote-ar-AR.js")
    TextResource ar_AR();

    @Source("resources/js/materialnote-bg-BG.js")
    TextResource bg_BG();

    @Source("resources/js/materialnote-ca-ES.js")
    TextResource ca_ES();

    @Source("resources/js/materialnote-cs-CZ.js")
    TextResource cs_CZ();

    @Source("resources/js/materialnote-da-DK.js")
    TextResource da_DK();

    @Source("resources/js/materialnote-de-DE.js")
    TextResource de_DE();

    @Source("resources/js/materialnote-el-GR.js")
    TextResource el_GR();

    @Source("resources/js/materialnote-en-US.js")
    TextResource en_US();

    @Source("resources/js/materialnote-es-ES.js")
    TextResource es_ES();

    @Source("resources/js/materialnote-es-EU.js")
    TextResource es_EU();

    @Source("resources/js/materialnote-fa-IR.js")
    TextResource fa_IR();

    @Source("resources/js/materialnote-fi-FI.js")
    TextResource fi_FI();

    @Source("resources/js/materialnote-fr-FR.js")
    TextResource fr_FR();

    @Source("resources/js/materialnote-gl-ES.js")
    TextResource gl_ES();

    @Source("resources/js/materialnote-he-IL.js")
    TextResource he_IL();

    @Source("resources/js/materialnote-hr-HR.js")
    TextResource hr_HR();

    @Source("resources/js/materialnote-hu-HU.js")
    TextResource hu_HU();

    @Source("resources/js/materialnote-id-ID.js")
    TextResource id_ID();

    @Source("resources/js/materialnote-it-IT.js")
    TextResource it_IT();

    @Source("resources/js/materialnote-ja-JP.js")
    TextResource ja_JP();

    @Source("resources/js/materialnote-ko-KR.js")
    TextResource ko_KR();

    @Source("resources/js/materialnote-lt-LT.js")
    TextResource lt_LT();

    @Source("resources/js/materialnote-lt-LV.js")
    TextResource lt_LV();

    @Source("resources/js/materialnote-mn-MN.js")
    TextResource mn_MN();

    @Source("resources/js/materialnote-nb-NO.js")
    TextResource nb_NO();

    @Source("resources/js/materialnote-nl-NL.js")
    TextResource nl_NL();

    @Source("resources/js/materialnote-pl-PL.js")
    TextResource pl_PL();

    @Source("resources/js/materialnote-pt-BR.js")
    TextResource pt_BR();

    @Source("resources/js/materialnote-pt-PT.js")
    TextResource pt_PT();

    @Source("resources/js/materialnote-ro-RO.js")
    TextResource ro_RO();

    @Source("resources/js/materialnote-ru-RU.js")
    TextResource ru_RU();

    @Source("resources/js/materialnote-sk-SK.js")
    TextResource sk_SK();

    @Source("resources/js/materialnote-sl-SI.js")
    TextResource sl_SI();

    @Source("resources/js/materialnote-sr-RS.js")
    TextResource sr_RS();

    @Source("resources/js/materialnote-sv-SE.js")
    TextResource sv_SE();

    @Source("resources/js/materialnote-ta-IN.js")
    TextResource ta_IN();

    @Source("resources/js/materialnote-th-TH.js")
    TextResource th_TH();

    @Source("resources/js/materialnote-tr-TR.js")
    TextResource tr_TR();

    @Source("resources/js/materialnote-uk-UA.js")
    TextResource uk_UA();

    @Source("resources/js/materialnote-vi-VN.js")
    TextResource vi_VN();

    @Source("resources/js/materialnote-zh-CN.js")
    TextResource zh_CN();

    @Source("resources/js/materialnote-zh-TW.js")
    TextResource zh_TW();

}
