/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package pl.pwr.simpleandroidtvapp;

import android.graphics.drawable.Drawable;

public class Image {

    private static final String TAG = pl.pwr.simpleandroidtvapp.Image.class.getSimpleName();

    static final long serialVersionUID = 727566175075960653L;
    private long id;
    private Drawable image;
    private String title;

    public Image() {
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Drawable getImage() { return image; }

    public void setImage(Drawable image) { this.image = image; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}