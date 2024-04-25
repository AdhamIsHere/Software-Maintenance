package jmemorize.gui.swing.actions.edit;

import java.awt.event.KeyEvent;

import jmemorize.core.Card;
import jmemorize.core.CardSide;
import jmemorize.gui.LC;
import jmemorize.gui.Localization;
import jmemorize.gui.swing.SelectionProvider;
import jmemorize.gui.swing.SelectionProvider.SelectionObserver;
import jmemorize.gui.swing.actions.AbstractAction2;

/**
 * An action that swaps the sides of all currently selected cards.
 *
 * @author [Your Name]
 */
public class ReverseCardAction extends AbstractAction2 implements SelectionObserver
{
    private SelectionProvider m_selectionProvider;

    public ReverseCardAction(SelectionProvider selectionProvider)
    {
        m_selectionProvider = selectionProvider;
        m_selectionProvider.addSelectionObserver(this);
        setValues();

        updateEnablement();
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener
     */
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        // Implement logic to swap card sides for all selected cards

        for (Card card : m_selectionProvider.getSelectedCards())
        {
            // Get the current front and back sides of the card
            CardSide front = card.getFrontSide();
            CardSide back = card.getBackSide();

            // Swap the sides
            card.setM_frontSide(back);
            card.setM_backSide(front);
        }
    }


    /* (non-Javadoc)
     * @see jmemorize.gui.swing.SelectionProvider.SelectionObserver
     */
    public void selectionChanged(SelectionProvider source)
    {
        updateEnablement();
    }

    private void updateEnablement()
    {
        setEnabled(m_selectionProvider.getSelectedCards() != null &&
                m_selectionProvider.getSelectedCards().size() > 0);
    }
    private void setValues()
    {
        setName("Swap Sides");
        setDescription("Swap the front and back sides of the selected cards.");

        setMnemonic(1);
//        setAccelerator(KeyEvent.VK_S, SHORTCUT_KEY);
    }

}