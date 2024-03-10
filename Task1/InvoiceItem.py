class Item:
    def __init__(self, name, net_amount, vat_rate):
        self.name = name
        self.net_amount = net_amount
        self.vat_rate = vat_rate

    def calculate_gross_amount(self):
        return self.net_amount + (self.net_amount * self.vat_rate / 100)


class Invoice:
    def __init__(self, items):
        self.items = items

    def calculate_invoice(self):
        total_net_amount_vat8 = 0
        total_net_amount_vat23 = 0
        total_vat8 = 0
        total_vat23 = 0

        for item in self.items:
            if item.vat_rate == 8:
                total_vat8 += item.calculate_gross_amount() - item.net_amount
                total_net_amount_vat8 += item.net_amount
            elif item.vat_rate == 23:
                total_vat23 += item.calculate_gross_amount() - item.net_amount
                total_net_amount_vat23 += item.net_amount

        return total_net_amount_vat8, total_vat8, total_net_amount_vat23, total_vat23

    def generate_markdown(self):
        total_net_amount_vat8, total_vat8, total_net_amount_vat23, total_vat23 = (
            self.calculate_invoice()
        )
        markdown_content = (
            "| | Total netto | Total VAT |\n"
            "|:--------------|:------------:|:----------:|\n"
            f"| VAT 8% | {total_net_amount_vat8:.2f} | {total_vat8:.2f} |\n"
            f"| VAT 23% | {total_net_amount_vat23:.2f} | {total_vat23:.2f} |\n"
        )
        with open("invoice_outputpy.md", "w") as writer:
            writer.write(markdown_content)
        return markdown_content

    def print_summary(self):
        total_net_amount_vat8, total_vat8, total_net_amount_vat23, total_vat23 = (
            self.calculate_invoice()
        )
        print("| | Total netto | Total VAT |")
        print("|:--------------|:------------:|:----------:|")
        print(f"| VAT 8% | {total_net_amount_vat8:.2f} | {total_vat8:.2f} |")
        print(f"| VAT 23% | {total_net_amount_vat23:.2f} | {total_vat23:.2f} |")


# Input items
items = [
    Item("Clean Code, Robert C. Martin", 100.00, 8),
    Item("Applying UML and Patterns, C. Larman", 300.00, 8),
    Item("Shipping", 50.00, 23),
]

# Create Invoice instance
invoice = Invoice(items)

# Calculate values
invoice.calculate_invoice()

# Markdown generate
invoice.generate_markdown()

# Print summary
invoice.print_summary()
