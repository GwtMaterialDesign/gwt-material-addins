/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package gwt.material.design.incubator.client.infinitescroll.data;

public class LoadConfig<T> {

    private final int offset;
    private final int limit;

    public LoadConfig(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    /**
     * Get load offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Get load limit. Set to "0" for no limit.
     */
    public int getLimit() {
        return limit;
    }
}
