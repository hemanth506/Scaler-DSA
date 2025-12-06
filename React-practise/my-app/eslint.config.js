import js from '@eslint/js'
import globals from 'globals'
import reactHooks from 'eslint-plugin-react-hooks'
import reactRefresh from 'eslint-plugin-react-refresh'
import { defineConfig } from 'eslint/config'

// Minimal JS/JSX configuration for the project (no TypeScript)
export default defineConfig({
  ignores: ['dist'],
  overrides: [
    {
      files: ['**/*.{js,jsx}'],
      extends: [js.configs.recommended],
      languageOptions: {
        ecmaVersion: 2020,
        sourceType: 'module',
        globals: globals.browser,
        parserOptions: { ecmaFeatures: { jsx: true } },
      },
      plugins: {
        'react-hooks': reactHooks,
        'react-refresh': reactRefresh,
      },
    },
  ],
})
