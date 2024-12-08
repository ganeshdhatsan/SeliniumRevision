/*
 * package Xpaths;
 * 
 * public class CSSSelector {
 * 
 * Here is a comprehensive breakdown of **CSS Selector syntax** for different
 * conditions in Selenium:
 * 
 * 1. **Basic Selector** Select elements based on tag name: ```css tagname ```
 * Example: `div` selects all `<div>` elements.
 * 
 * 2. **ID Selector** Select elements based on their ID attribute: ```css #id
 * ``` Example: `#username` selects the element with `id="username"`.
 * 
 * 3. **Class Selector** Select elements based on their class attribute: ```css
 * .class ``` Example: `.button` selects all elements with `class="button"`.
 * 
 * 4. **Attribute Selector** Select elements based on their attribute value:
 * ```css [attribute="value"] ``` Example: `[type="text"]` selects all `<input>`
 * elements with `type="text"`.
 * 
 * 5. **Attribute Selector with Partial Match** - **Starts with**: ```css
 * [attribute^="value"] ``` Example: `[href^="https"]` selects all elements with
 * `href` starting with "https". - **Ends with**: ```css [attribute$="value"]
 * ``` Example: `[src$=".jpg"]` selects all elements with `src` ending in
 * ".jpg". - **Contains**: ```css [attribute*="value"] ``` Example:
 * `[title*="test"]` selects all elements where the `title` contains "test".
 * 
 * 6. **Descendant Selector** Selects elements that are descendants of a given
 * element: ```css parent descendant ``` Example: `div p` selects all `<p>`
 * elements inside `<div>` elements.
 * 
 * 7. **Child Selector** Selects direct children of a given element: ```css
 * parent > child ``` Example: `div > p` selects all `<p>` elements that are
 * direct children of `<div>` elements.
 * 
 * 8. **Adjacent Sibling Selector** Selects an element that is immediately
 * preceded by a given element: ```css element1 + element2 ``` Example: `h1 + p`
 * selects the first `<p>` element immediately following an `<h1>`.
 * 
 * 9. **General Sibling Selector** Selects all elements that are siblings of a
 * given element: ```css element1 ~ element2 ``` Example: `h1 ~ p` selects all
 * `<p>` elements that are siblings of `<h1>`.
 * 
 * 10. **Multiple Conditions** Combine multiple conditions to narrow down the
 * selection: ```css element[attribute="value"].class ``` Example:
 * `input[type="text"].valid` selects all `<input>` elements with `type="text"`
 * and `class="valid"`.
 * 
 * 11. **Pseudo-classes** - **First-child**: ```css :first-child ``` Example:
 * `div:first-child` selects the first child `<div>` element within a parent. -
 * **Last-child**: ```css :last-child ``` Example: `div:last-child` selects the
 * last child `<div>` element within a parent. - **Nth-child**: ```css
 * :nth-child(n) ``` Example: `li:nth-child(2)` selects the second `<li>`
 * element in a list. - **Hover**: ```css :hover ``` Example: `a:hover` selects
 * an `<a>` element when it is hovered over.
 * 
 * 12. **Pseudo-elements** - **First letter**: ```css ::first-letter ```
 * Example: `p::first-letter` selects the first letter of a `<p>` element. -
 * **First line**: ```css ::first-line ``` Example: `p::first-line` selects the
 * first line of a `<p>` element.
 * 
 * 13. **Universal Selector** Selects all elements: ```css
 *
 * ``` Example: `*` selects all elements on the page.
 * 
 * 14. **Empty Elements** Selects elements with no child elements: ```css :empty
 * ``` Example: `div:empty` selects `<div>` elements with no child elements.
 * 
 * Apologies for the formatting issue. Here's the corrected version without the
 * unnecessary asterisks:
 * 
 * 
 * 
 * }
 */