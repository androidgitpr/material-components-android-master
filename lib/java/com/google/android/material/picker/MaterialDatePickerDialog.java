/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.material.picker;

import com.google.android.material.R;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import java.util.Calendar;

/**
 * A {@link Dialog} with a header, {@link MaterialDatePickerView}, and set of actions.
 *
 * @hide
 */
@RestrictTo(Scope.LIBRARY_GROUP)
public class MaterialDatePickerDialog extends MaterialPickerDialog<Calendar> {

  private final MaterialDatePickerView materialDatePicker;

  public MaterialDatePickerDialog(Context context) {
    this(context, 0);
  }

  public MaterialDatePickerDialog(Context context, int themeResId) {
    super(context, getThemeResource(context, R.attr.materialDatePickerDialogTheme, themeResId));
    // Ensure we are using the correctly themed context rather than the context that was passed in.
    context = getContext();
    materialDatePicker = new MaterialDatePickerView(context);
  }

  @Override
  protected MaterialCalendarView<Calendar> getMaterialCalendarView() {
    return materialDatePicker;
  }

  @Override
  protected String getHeaderText() {
    Calendar selectedDate = materialDatePicker.getSelection();
    if (selectedDate == null) {
      return getContext().getResources().getString(R.string.mtrl_picker_header_prompt);
    }
    String startString = getSimpleDateFormat().format(selectedDate.getTime());
    return getContext().getResources().getString(R.string.mtrl_picker_header_selected, startString);
  }
}
