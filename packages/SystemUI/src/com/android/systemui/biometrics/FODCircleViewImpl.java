/**
 * Copyright (C) 2019 The Android Open Source Project
 *
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
 */

package com.android.systemui.biometrics;

import android.content.pm.PackageManager;
import android.view.View;

import com.android.systemui.SystemUI;
import com.android.systemui.statusbar.CommandQueue;
import com.android.systemui.statusbar.CommandQueue.Callbacks;

<<<<<<< HEAD
=======
import com.android.internal.util.custom.fod.FodScreenOffHandler;
import com.android.internal.util.evolution.fod.FodUtils;

import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
>>>>>>> 5e1e5df3dbc... fwb: SystemUI: Use FODUtils for FOD config checking [1/3]

public class FODCircleViewImpl extends SystemUI implements CommandQueue.Callbacks {
    private static final String TAG = "FODCircleViewImpl";

    private FODCircleView mFodCircleView;

    @Override
    public void start() {
        PackageManager packageManager = mContext.getPackageManager();
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT) ||
                !FodUtils.hasFodSupport(mContext)) {
            return;
        }
        getComponent(CommandQueue.class).addCallback(this);
        try {
            mFodCircleView = new FODCircleView(mContext);
        } catch (RuntimeException e) {
            // do nothing
        }
    }

    @Override
    public void showInDisplayFingerprintView() {
        if (mFodCircleView != null) {
            mFodCircleView.show();
        }
    }

    @Override
    public void hideInDisplayFingerprintView() {
        if (mFodCircleView != null) {
            mFodCircleView.hide();
        }
    }
}
