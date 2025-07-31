# android-keyboard-cache-disable

Android secure input pattern: Disabling keyboard cache when entering sensitive information like passwords or personal data.  
資安檢測實務：在 Android 輸入敏感資訊時，停用鍵盤快取機制的實作與說明。

---

## 🔒 背景說明

在進行資安檢測時，若輸入欄位允許顯示建議文字、保留輸入記錄或啟用自動填寫，可能會被認定為風險項目，特別是針對密碼或帳號等敏感欄位。因此應關閉以下功能：

- 鍵盤建議詞（Suggestions / Predictive Text）
- 輸入快取（Keyboard Cache）
- 自動填寫（Autofill）

---

## ✅ 解法實作

以下是針對帳號與密碼欄位的修正範例程式碼：

```kotlin
// 資安檢測修正：關閉建議、快取、自動填寫等功能

// 先保留原本的 Typeface（設定 inputType 會導致字體被系統重置）
val originalUserIdTypeface = edtUserID.typeface
val originalUserPwdTypeface = edtUserPwd.typeface

// 帳號欄位
edtUserID.inputType = InputType.TYPE_CLASS_TEXT or
        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD or
        InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
edtUserID.setAutofillHints(null)
ViewCompat.setImportantForAutofill(edtUserID, View.IMPORTANT_FOR_AUTOFILL_NO)
edtUserID.setPrivateImeOptions("disableSuggestions")
edtUserID.typeface = originalUserIdTypeface // 設回原本字體

// 密碼欄位
edtUserPwd.inputType = InputType.TYPE_CLASS_TEXT or
        InputType.TYPE_TEXT_VARIATION_PASSWORD or
        InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
edtUserPwd.setAutofillHints(null)
ViewCompat.setImportantForAutofill(edtUserPwd, View.IMPORTANT_FOR_AUTOFILL_NO)
edtUserPwd.setPrivateImeOptions("disableSuggestions")
edtUserPwd.typeface = originalUserPwdTypeface // 設回原本字體
