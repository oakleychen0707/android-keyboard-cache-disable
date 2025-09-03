private fun setupSecureInputs() {
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
}
