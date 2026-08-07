# Jetpack Compose UI Practice 🚀

A modern Android application showcasing clean, production-ready **Jetpack Compose** UI designs, custom components, and interactive card layouts inspired by real-world apps (such as PayPal UI components).

---

## 🎨 Features & Components

- **PayPal Balance Card (`PaypalBalanceCard.kt`)**
  - Custom rounded card with dual-tone layout (White balance section + Vibrant Blue promotional banner).
  - Material 3 components (`Card`, `Surface`, `Icon`, `Text`).
  - Dynamic parameters for title, balance amount, promotional content, and click actions.

- **PayPal Balance Active Card (`PayPalBalanceActiveCard.kt`)**
  - Action items row (`Add Money`, `Transfer`, `Account info`).
  - Badge tag ("Activate PayPal Debit card").
  - Responsive banner layout with properly weighted text and trailing action icon.

---

## 🛠 Tech Stack & Tools

- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Language:** Kotlin
- **Build System:** Gradle (Kotlin DSL `.gradle.kts`) with Version Catalog (`libs.versions.toml`)
- **Icons:** Material Icons Extended (`androidx.compose.material:material-icons-extended`)
- **Minimum SDK:** 24 (Android 7.0)
- **Target SDK:** 36

---

## 📂 Project Structure

```text
app/src/main/java/com/rajjaviya/jetpackcomposeui/
├── MainActivity.kt
└── ui/
    ├── components/
    │   ├── PaypalBalanceCard.kt
    │   └── PayPalBalanceActiveCard.kt
    └── theme/
        ├── Color.kt
        ├── Theme.kt
        └── Type.kt
```

---

## 🚀 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/JetpackComposeUI.git
   cd JetpackComposeUI
   ```

2. **Open in Android Studio:**
   - Open **Android Studio (Ladybug / Iguana or newer)**.
   - Select **Open an existing project** and choose the `JetpackComposeUI` folder.

3. **Build & Run:**
   - Sync Gradle project.
   - Run on an Emulator or connected Android Device (`Shift + F10`).

---

## 📸 Component Previews

Each component includes an `@Preview` annotation for real-time visualization in Android Studio's Compose Design Preview:
- `PaypalBalanceCardPreview`
- `PayPalBalanceActiveCard`
